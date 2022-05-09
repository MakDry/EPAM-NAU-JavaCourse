package ua.advanced.practice6.factory.plot;

import ua.advanced.practice6.customAnnotations.Range;

public class PlotFactories {

    @Range
    public PlotFactory classicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        String heroName = hero.name();
        String belovedName = beloved.name();
        String villainName = villain.name();

        return () -> new Plot() {
            @Override
            public String toString() {
                return heroName + " is great. "+ heroName + " and " + belovedName +
                        " love each other. " + villainName + " interferes with their happiness but loses in the end.";
            }
        };
    }

    @Range(min = 300, max = 360)
    public PlotFactory contemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        String heroName = hero.name();
        String epicCrisisName = epicCrisis.name();
        String funnyFriendName = funnyFriend.name();

        return () -> new Plot() {
            @Override
            public String toString() {
                return heroName + " feels a bit awkward and uncomfortable. But personal issues fades, when a big trouble comes - " +
                        epicCrisisName + ". " + heroName + " stands up against it, but with no success at first.But putting self together and help of friends, including spectacular funny " +
                        funnyFriendName + " restore the spirit and " + heroName + " overcomes the crisis and gains gratitude and respect";
            }
        };
    }

    @Range(min = 110, max = 400)
    public PlotFactory marvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        String epicCrisisName = epicCrisis.name();
        String villainName = villain.name();

        return () -> new Plot() {
            @Override
            public String toString() {
                String plot = epicCrisisName.concat(" threatens the world. But");
                for (int i = 0; i < heroes.length; i++) {
                    plot = plot.concat(" brave " + heroes[i].name());
                    if (i != heroes.length - 1)
                        plot = plot.concat(",");
                }
                return plot.concat(" on guard. So, no way that intrigues of " + villainName + " overcome the willpower of inflexible heroes");
            }
        };
    }
}
