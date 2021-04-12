package fitness;

import java.util.Arrays;

public class Fitness {
    private Subscription[] swimmingPools;
    private Subscription[] gums;
    private Subscription[] groupLessonses;
    public Subscription[] subscriptions;
    private int MaxCount = Settings.MAX_COUNT;
    private int FinalCount = Settings.FINAL_COUNT;

    public Fitness() {
        this.swimmingPools = new Subscription[MaxCount];
        this.gums = new Subscription[MaxCount];
        this.groupLessonses = new Subscription[MaxCount];
        this.subscriptions = new Subscription[FinalCount];
    }

    public void addSubscription(Subscription subscription){
        for (int i = 0,j=subscriptions.length-1; i <subscriptions.length||j!=i||j>0 ; i++,j--) {
            if(subscriptions[i]==null){
                subscriptions[i]=subscription;
                return;
            }
            //if(subscriptions[i].getSurname()==subscriptions[j].getSurname())throw new IllegalArgumentException("Такой абонемент уже есть");
        }
        for (String surname:subscriptions) {
            throw new IllegalArgumentException("Такой абонемент уже есть");
        }

    }
    public void addSwimmingPool(Subscription subscription) {
        if (subscription.getSubscriptionTypes().swimmingPool == false)
            throw new IllegalArgumentException("Ваш абонемент не позволяет посетить данное место");
        for (int i = 0; i < swimmingPools.length; i++) {
            if (swimmingPools[i] == null) {
                swimmingPools[i] = subscription;
                return;
            }
            if (i >= swimmingPools.length) throw new IllegalArgumentException("Мест нет");
        }
    }

    public void addGums(Subscription subscription) {
        if (subscription.getSubscriptionTypes().gum == false)
            throw new IllegalArgumentException("Ваш абонемент не позволяет посетить данное место");
        for (int i = 0; i < gums.length; i++) {
            if (gums[i] == null) {
                gums[i] = subscription;
                return;
            }
            if (i >= gums.length) throw new IllegalArgumentException("Мест нет");
        }
    }

    public void addGroupLessonses(Subscription subscription) {
        if (subscription.getSubscriptionTypes().groupLessons == false)
            throw new IllegalArgumentException("Ваш абонемент не позволяет посетить данное место");
        for (int i = 0; i < groupLessonses.length; i++) {
            if (groupLessonses[i] == null) {
                groupLessonses[i] = subscription;
                return;
            }
            if (i >= groupLessonses.length) throw new IllegalArgumentException("Мест нет");
        }
    }

    @Override
    public String toString() {
        return "Fitness{" +
                "swimmingPools=" + Arrays.toString(swimmingPools) +
                ", gums=" + Arrays.toString(gums) +
                ", groupLessonses=" + Arrays.toString(groupLessonses) +
                ", addSubscription=" + Arrays.toString(subscriptions) +
                '}';
    }
}


