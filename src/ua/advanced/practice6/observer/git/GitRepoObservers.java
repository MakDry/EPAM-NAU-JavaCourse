package ua.advanced.practice6.observer.git;

public class GitRepoObservers {
    public static Repository newRepository(){
        return new Repository() {

            @Override
            public void addWebHook(WebHook webHook) {

            }

            @Override
            public Commit commit(String branch, String author, String[] changes) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void merge(String sourceBranch, String targetBranch) {

            }
        };
    }

    public static WebHook mergeToBranchWebHook(String branchName){
        throw new UnsupportedOperationException();
    }

    public static WebHook commitToBranchWebHook(String branchName){
        throw new UnsupportedOperationException();
    }
}
