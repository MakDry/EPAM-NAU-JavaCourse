package ua.advanced.practice6.observer.git;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {
    List<WebHook> webHooks;
    List<Commit> commits;

    public RepositoryImpl() {
        this.webHooks = new ArrayList<>();
        this.commits = new ArrayList<>();
    }

    @Override
    public void addWebHook(WebHook webHook) {
        webHooks.add(webHook);
    }

    @Override
    public Commit commit(String branch, String author, String[] changes) {
        Commit newCommit = new Commit(author, changes);
        List<Commit> eventCommit = new ArrayList<>();
        eventCommit.add(newCommit);

        if (!webHooks.isEmpty()) {
            commits.add(newCommit);
            webHooks.stream().filter(event -> event.branch().equals(branch) && event.type() == Event.Type.COMMIT)
                    .findAny().ifPresent(commitWebHook -> commitWebHook.onEvent(new Event(Event.Type.COMMIT, branch, eventCommit)));

        }
        return newCommit;
    }

    @Override
    public void merge(String sourceBranchName, String targetBranchName) {
        if (!webHooks.isEmpty()) {
            WebHook sourceBranchWebHook = webHooks.stream().filter(event -> event.branch().equals(sourceBranchName) && event.type() == Event.Type.COMMIT)
                    .findAny().orElse(null);
            WebHook targetBranchWebHook = webHooks.stream().filter(event -> event.branch().equals(targetBranchName) && event.type() == Event.Type.MERGE)
                    .findAny().orElse(null);

            if (sourceBranchWebHook != null && targetBranchWebHook != null) {
                List<Commit> eventCommits = new ArrayList<>();

                for (var event : sourceBranchWebHook.caughtEvents()) {
                    eventCommits.addAll(event.commits());
                }

                if (!eventCommits.isEmpty())
                    targetBranchWebHook.onEvent(new Event(Event.Type.MERGE, targetBranchName, eventCommits));

                webHooks.set(webHooks.indexOf(sourceBranchWebHook), new WebHookImpl(sourceBranchWebHook.branch(), sourceBranchWebHook.type()));
            }
        }
    }
}