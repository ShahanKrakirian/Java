public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    //REMOVE
    public void remove(){
        if (head == null){
            return;
        }
        if (head.next == null){
            head = null; 
            return;
        }
        Node runner = head;
        while (runner.next.next != null){
            runner = runner.next;
        }
        runner.next = null;
    }
    //PRINT VALUES
    public void printValues(){
        if (head == null){
            return;
        }
        Node runner = head;
        while (runner != null){
            System.out.println(runner.value);
            runner = runner.next;
        }
    }
    //ADD
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    public Node find(int num){
        Node runner = head;
        // if (head == null){
        //     return runner;
        // }
        while(runner != null){
            if (runner.value == num){
                return runner;
            } else {
                runner = runner.next;
            }
        }
        return runner;
    }
    public void removeAt(int num){
        Node runner = head;
        if (num == 0){
            head = head.next;
            return;
        }
        int count = 1;
        while (runner.next != null){
            if (count == num){
                runner.next = runner.next.next;
                return;
            }
            runner = runner.next;
            count += 1;
        }
        System.out.println("List isn't that long.");
    }    
}