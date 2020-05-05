enum Channel {
    ABC(1),
    CARTOON(2),
    DISCOVERY(3),
    MTV(4),
    HISTORY(5);

    private final int num;

    private Channel(int n) {
        num = n;
    }

    public int getNum() { // returns channel number
        return num;
    }
}

public class Television {
    private Channel channel;

    public Television(Channel channel) {
        this.channel = channel;
    }

    public void changeChannel() {
        switch (channel) {
            case ABC:
                System.out.println("ABC channel on " + channel.getNum() + ". Be updated with news 24/7.");
                break;

            case CARTOON:
                System.out.println("Cartoon channel on " + channel.getNum() + " for all kids");
                break;

            case DISCOVERY:
                System.out.println("Discovery channel on " + channel.getNum() + ". Get to know nature.");
                break;

            case MTV:
                System.out.println("MTV channel on " + channel.getNum() + ". Enjoy music!");
                break;

            case HISTORY:
                System.out.println("History channel on " + channel.getNum() + ". Discover the past!");
                break;

        }
    }
}
