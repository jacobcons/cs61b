package deque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque {
    Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {
        return max(comparator);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }

        T maxElement = (T) get(0);
        for (int i = 1; i < size(); i++) {
            T currentElement = (T) get(i);
            if (c.compare(currentElement, maxElement) > 0) {
                maxElement = currentElement;
            }
        }
        return maxElement;
    }
}
