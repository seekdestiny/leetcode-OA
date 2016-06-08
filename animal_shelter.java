class Node {
    public String name;
    public int type;
    public Node next;
    public Node(String name, int type) {
        this.name = name;
        this.type = type;
        this.next = null;
    }
}

public class AnimalShelter {

    private Node first, last;

    public AnimalShelter() {
        // do initialize if necessary
        first = last = null;
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        // Write your code here
        if (first == null) {
            last = new Node(name, type);
            first = last;
        } else {
            last.next = new Node(name, type);
            last = last.next;
        }
    }

    public String dequeueAny() {
        // Write your code here
        if (first != null) {
            String res = first.name;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return res;
        }
        
        return "";
    }

    public String dequeueDog() {
        // Write your code here
        return dequeueType(1);
    }

    public String dequeueCat() {
        // Write your code here
        return dequeueType(0);
    }
    
    private String dequeueType(int type) {
        if (first != null) {
            if (first.type == type) {
                return dequeueAny();
            } else {
                Node track = first;
                while (track.next != null) {
                    if (track.next.type == type) {
                        String res = track.next.name;
                        if (track.next == last) { // if deleted node is the last one
                            last = track;
                        }
                        track.next = track.next.next;
                        return res;
                    }
                    
                    track = track.next;
                }
            }
        }
        
        return "";
    }
}
