package fitness;

import java.time.LocalTime;

public class Subscription extends PersonalData {
    private SubscriptionTypes subscriptionTypes;
    public LocalTime timeStart;

    public Subscription(String surname, String name) {
        super(surname, name);
    }

    public enum SubscriptionTypes {
        ONE_OFF(true, true, false, LocalTime.of(Settings.MIN_TIME_HOUR, Settings.TIME_MINUTE), LocalTime.of(Settings.MAX_TIME_HOUR, Settings.TIME_MINUTE)),
        DIURNAL(false, true, true, LocalTime.of(Settings.MIN_TIME_HOUR, Settings.TIME_MINUTE), LocalTime.of(Settings.MAX_TIME_DIURNAL_HOUR, Settings.TIME_MINUTE)),
        FULL(true, true, true, LocalTime.of(Settings.MIN_TIME_HOUR, Settings.TIME_MINUTE), LocalTime.of(Settings.MAX_TIME_HOUR, Settings.TIME_MINUTE));
        public boolean swimmingPool;
        public boolean gum;
        public boolean groupLessons;
        private LocalTime time1;
        private LocalTime time2;

        SubscriptionTypes(boolean swimmingPool, boolean gum, boolean groupLessons, LocalTime time1, LocalTime time2) {
            this.swimmingPool = swimmingPool;
            this.gum = gum;
            this.groupLessons = groupLessons;
            this.time1 = time1;
            this.time2 = time2;
        }
    }

    public void setSubscriptionTypes(SubscriptionTypes subscriptionTypes) {
        this.subscriptionTypes = subscriptionTypes;
    }

    public SubscriptionTypes getSubscriptionTypes() {
        return subscriptionTypes;
    }

    public void setTimeStart(LocalTime timeStart) {
        boolean isBefore = timeStart.isBefore(SubscriptionTypes.FULL.time1);
        boolean isAfter1 = timeStart.isAfter(SubscriptionTypes.DIURNAL.time2);
        boolean isAfter2 = timeStart.isAfter(SubscriptionTypes.FULL.time2);

        if (isBefore) throw new IllegalArgumentException("Вы пришли рано");
        if (isAfter2 && (SubscriptionTypes.ONE_OFF.equals(getSubscriptionTypes()) || SubscriptionTypes.FULL.equals(getSubscriptionTypes())))
            throw new IllegalArgumentException("Вы пришли поздно");
        if (isAfter1 && SubscriptionTypes.DIURNAL.equals(getSubscriptionTypes()))
            throw new IllegalArgumentException("Вы пришли поздно");
        if(dateOfVisite.isAfter(expirationDate))throw new IllegalArgumentException("Срок абонемента истек");
        this.timeStart = timeStart;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "surname = '" + surname + '\'' +
                ", name = '" + name + '\'' +
                ", dateOfVisite = '" + dateOfVisite + '\'' +
                "subscriptionTypes = '" + subscriptionTypes + '\'' +
                '}';
    }

}
