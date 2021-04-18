package fitness;

import java.time.LocalTime;

/*      + Задача «Фитнес»
        + В фитнес клубе есть три типа абонементов:
        + Разовый. По разовому абонементу клиенты могут посещать бассейн и тренажерный зал с 8 до 22 часов.
        + Дневной. По данному абонементу клиенты могут посещать тренажерный зал и групповые занятия (но не бассейн) с 8 до 16 часов.
        + Полный. По данному абонементу клиенты могут посещать тренажерный зал, бассейн и групповые занятия с 8 до 22 часов.

        + Каждый абонемент хранит дату регистрации (текущая дата) и дату окончания регистрации.
        + Каждый абонемент хранит информацию о владельце. Данные о владельце: имя, фамилия, год рождения.

        + Фитнес содержит информацию об абонементах:
        + которые зарегистрированы в данный момент в тренажерном зале;
        + абонементах, которые зарегистрированы в бассейне;
        + абонементах, которые зарегистрированы на групповых занятиях.

        + В каждой зоне (бассейн, тренажерный зал, групповые занятия) одновременно может быть зарегистрировано 20 абонементов.

        + Когда фитнес клуб закрывается, клиенты покидают его.

        + Когда клиент приходит в фитнес клуб, он сообщает желаемую зону и показывает абонемент.
        + Необходимо проверить может ли данный посетитель пройти в желаемую зону и пропустить его,
        + если возможность существует; если посетитель не может пройти, необходимо сообщить ему причину.

        + Посетитель не может пройти, если абонемент просрочен,
        + если он пытается пройти в зону, которая не разрешена по его абонементу,
        + если в зоне нет свободных мест.

        + Абонемент не может быть зарегистрирован одновременно в нескольких зонах.

        + Реализовать возможность вывода информации о посетителях:
        + сначала посетителях тренажерного зала, потом бассейна, потом групповых занятий.

        + Реализовать возможность выводить информацию в консоль каждый раз, когда клиент посещает фитнес клуб.
        + Информация для вывода:
        + Фамилия
        + Имя
        + Посещаемаю зона (бассейн/тренажерный зал/групповые занятия)
        + Дата и время посещения

 */
public class Start {
    public static void main(String[] args) {
        //Ввод данных
        Subscription subscription1 = new Subscription("Абрамов", "Максим");
        Subscription subscription2 = new Subscription("Адамчук", "Виталий");
        Subscription subscription3 = new Subscription("Коморов", "Виталий");
        Subscription subscription4 = new Subscription("Беликов", "Дмитрий");
        Subscription subscription5 = new Subscription("Барловская", "Алиса");
        Subscription subscription6 = new Subscription("Газманов", "Максим");
        Subscription subscription7 = new Subscription("Абрамова", "Светлана");
        Subscription subscription8 = new Subscription("Абрамов", "Максим");
        //выбор типа абонемента
        subscription1.setSubscriptionTypes(Subscription.SubscriptionTypes.FULL);
        subscription2.setSubscriptionTypes(Subscription.SubscriptionTypes.DIURNAL);
        subscription3.setSubscriptionTypes(Subscription.SubscriptionTypes.ONE_OFF);
        subscription4.setSubscriptionTypes(Subscription.SubscriptionTypes.ONE_OFF);
        subscription5.setSubscriptionTypes(Subscription.SubscriptionTypes.DIURNAL);
        subscription6.setSubscriptionTypes(Subscription.SubscriptionTypes.ONE_OFF);
        subscription7.setSubscriptionTypes(Subscription.SubscriptionTypes.DIURNAL);
        subscription8.setSubscriptionTypes(Subscription.SubscriptionTypes.FULL);
        //Проверка времени прихода клиента
        subscription1.setTimeStart(LocalTime.of(15, 0));
        subscription2.setTimeStart(LocalTime.of(16, 0));
        subscription3.setTimeStart(LocalTime.of(9, 0));
        subscription4.setTimeStart(LocalTime.of(22, 0));
        subscription5.setTimeStart(LocalTime.of(16, 0));
        subscription6.setTimeStart(LocalTime.of(14, 0));
        subscription7.setTimeStart(LocalTime.of(16, 0));
        subscription8.setTimeStart(LocalTime.of(12, 0));
        //проверка фимилии и имени на повторение
        /*
        fitness.addSubscription(subscription1);
        fitness.addSubscription(subscription2);
        fitness.addSubscription(subscription3);
        fitness.addSubscription(subscription4);
        fitness.addSubscription(subscription5);
        fitness.addSubscription(subscription6);
        fitness.addSubscription(subscription7);
        fitness.addSubscription(subscription8);
*/

        Fitness fitness = new Fitness();
 /*
        fitness.addGroupLessonses(subscription1);
        fitness.addGums(subscription1);
        fitness.addSwimmingPool(subscription8);
        fitness.addGums(subscription4);
        fitness.addSwimmingPool(subscription3);
        fitness.addGroupLessonses(subscription7);
        fitness.addGums(subscription5);
        fitness.addSwimmingPool(subscription6);
        fitness.addGroupLessonses(subscription2);
*/
        fitness.addStart(subscription1,"gum");
        fitness.addStart(subscription1,"swimmingpool");
        System.out.println(fitness);

    }
}
