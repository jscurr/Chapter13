package pp1305;

import com.github.javafaker.Faker;
import java.util.Arrays;
import java.util.TimerTask;

public class Bank {

    private final CustomerTask customerTask;
    private final TellerTask tellerTask;
    private CustomerQueue[] queues;
    final int NUMBER_OF_QUEUES = 4;

    public Bank() {
        makeQueues();
        customerTask = new CustomerTask();
        tellerTask = new TellerTask();
    }

    public void putCustomerInQueue(Customer newCustomer) {
        int indexOfShortestQueue = findShortestQueue();
        queues[indexOfShortestQueue].enqueue(newCustomer);
        System.out.println(Arrays.toString(queues));
    }
    public void serveCustomer() {
        int indexOfLongestQueue = findLongestQueue();
        System.out.println(queues[indexOfLongestQueue].getHead() + "has been served");
        queues[indexOfLongestQueue].dequeue();
        System.out.println(Arrays.toString(queues));
    }

    private int findShortestQueue() {
        int indexOfShortestQueue = 0;
        int sizeOfShortestQueue = Integer.MAX_VALUE;
        for (int queueIndex = 0; queueIndex < NUMBER_OF_QUEUES; queueIndex++) {
            if (queues[queueIndex].getLength() < sizeOfShortestQueue) {
                sizeOfShortestQueue = queues[queueIndex].getLength();
                indexOfShortestQueue = queueIndex;
            }
        }
        return indexOfShortestQueue;
    }

    private int findLongestQueue() {
        int indexOfLongestQueue = 0;
        int sizeOfLongestQueue = Integer.MIN_VALUE;
        for (int queueIndex = 0; queueIndex < NUMBER_OF_QUEUES; queueIndex++) {
            if (queues[queueIndex].getLength() > sizeOfLongestQueue) {
                sizeOfLongestQueue = queues[queueIndex].getLength();
                indexOfLongestQueue = queueIndex;
            }
        }
        return indexOfLongestQueue;
    }



    private void makeQueues() {
        this.queues = new CustomerQueue[NUMBER_OF_QUEUES];
        for (int i = 0; i < NUMBER_OF_QUEUES; i++) {
            this.queues[i] = new CustomerQueue();
        }
    }

    private class CustomerTask extends TimerTask {
        Faker faker = new Faker();

        @Override
        public void run() {
            String fullName = faker.name().fullName();
            putCustomerInQueue(new Customer(fullName));
        }
    }

    public CustomerTask getCustomerMaker() {
        return customerTask;
    }

    private class TellerTask extends TimerTask {
        @Override
        public void run() {
            serveCustomer();
        }
    }

    public TellerTask getTellerTask() {
        return tellerTask;
    }

}
