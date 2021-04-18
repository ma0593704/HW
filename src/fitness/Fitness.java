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

    //проверка одинаковой фамилии и имени
    public void addSubscription(Subscription subscription) {
        for (int i = 0; i < subscriptions.length; i++) {
            if (subscriptions[i] == null) {
                subscriptions[i] = subscription;
                return;
            }
            if (subscriptions[i].getSurname().equals(subscription.surname) && subscriptions[i].getName().equals(subscription.name))
                throw new IllegalArgumentException("Такой абонемент уже есть");

        }
    }

    public void addStart(Subscription subscription, String zone) {
        if (zone=="gum")addGums(subscription);
        if (zone=="swimmingpool")addSwimmingPool(subscription);
        if (zone=="grouplessons")addGroupLessonses(subscription);
    }

    //решил не делать отдельный метод а сделать проверки внутри каждого метода
    public void addSwimmingPool(Subscription subscription) {
        h:
        for (Subscription a : gums) {
            if (a == null) continue h;
            if (a.equals(subscription)) {
                System.out.println("Ваш абонемент в gum1");
                return;
            }
        }
        hh:
        for (Subscription с : groupLessonses) {
            if (с == null) continue hh;
            if (с.equals(subscription)) {
                System.out.println("Ваш абонемент в groupLessons1");
                return;
            }
        }

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
        hh:
        for (Subscription с : groupLessonses) {
            if (с == null) continue hh;
            if (с.equals(subscription)) {
                System.out.println("Ваш абонемент в groupLessons1");
                return;
            }
        }
        hhh:
        for (Subscription b : swimmingPools) {
            if (b == null) continue hhh;
            if (b.equals(subscription)) {
                System.out.println("Ваш абонемент в swimmingPool");
                return;
            }
        }

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
        hhh:
        for (Subscription b : swimmingPools) {
            if (b == null) continue hhh;
            if (b.equals(subscription)) {
                System.out.println("Ваш абонемент в swimmingPool1");
                return;
            }
        }
        h:
        for (Subscription a : gums) {
            if (a == null) continue h;
            if (a.equals(subscription)) {
                System.out.println("Ваш абонемент в gum1");
                return;
            }
        }
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
                '}';
    }
}


