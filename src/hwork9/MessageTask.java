package hwork9;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритета
        //  Ответ в консоль
        int countH = 0;
        int countL = 0;
        int countM = 0;
        int countU = 0;
        for (Message a : messageList) {
            if (a.getPriority() == Message.MessagePriority.HIGH) countH++;
            if (a.getPriority() == Message.MessagePriority.LOW) countL++;
            if (a.getPriority() == Message.MessagePriority.MEDIUM) countM++;
            if (a.getPriority() == Message.MessagePriority.URGENT) countU++;
        }
        System.out.println("HIGH = " + countH + " LOW = " + countL + " MEDIUM = " + countM + " URGENT = " + countU);
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;
        for (Message a : messageList) {
            if (a.getCode() == 0) count0++;
            if (a.getCode() == 9) count9++;
            if (a.getCode() == 1) count1++;
            if (a.getCode() == 2) count2++;
            if (a.getCode() == 3) count3++;
            if (a.getCode() == 4) count4++;
            if (a.getCode() == 5) count5++;
            if (a.getCode() == 6) count6++;
            if (a.getCode() == 7) count7++;
            if (a.getCode() == 8) count8++;
        }
        System.out.println("код 0 = " + count0 + " код 1 =  " + count1 + " код 2 = " + count2 + " код 3 = " + count3 + " код 4 = " +
                count4 + " код 5 = " + count5 + " код 6 = " + count6 + " код 7 = " + count7 + " код 8 = " + count8 + " код 9 = " + count9);
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message> messageHashSet = new HashSet<>();
        messageHashSet.addAll(messageList);
        System.out.println(messageHashSet.size());

    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        LinkedHashSet<Message> messageLinkedHashSet = new LinkedHashSet<>();
        messageLinkedHashSet.addAll(messageList);
        System.out.println(messageLinkedHashSet);
        return null;
    }

    public static List<Message> copyEach(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: создать коллекцию и передать в нее ссылки на каждое сообщение с заданным приоритетом
        //  метод должен вернуть новую коллекцию

        for (Message a : messageList) {
            if (a.getPriority() == Message.MessagePriority.HIGH) {
                List<Message> b = new ArrayList<>();
                b.add(a);
                System.out.println(b);
            }
        }
        return null;

    }

    public static List<Message> copyOther(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: создать коллекцию и передать в нее ссылки на все сообщения, кроме тех, которые имеют заданный приоритет
        //  метод должен вернуть новую коллекцию
        for (Message a : messageList) {
            if (!(a.getPriority() == Message.MessagePriority.HIGH)) {
                List<Message> b = new ArrayList<>();
                b.add(a);
                System.out.println(b);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Message> messages = Message.MessageGenerator.generate(34);
        System.out.println(messages);
        // вызов методов
        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        uniqueMessagesInOriginalOrder(messages);
        copyEach(messages, Message.MessagePriority.HIGH);
        System.out.println();
        copyOther(messages, Message.MessagePriority.HIGH);

    }
}