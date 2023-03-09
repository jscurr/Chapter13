package pp1301;

public class MagazineList {
    private MagazineNode firstNode;

    public MagazineList(){
        firstNode = null;
    }

    public void add(Magazine magazine){
        MagazineNode newNode = new MagazineNode(magazine);
        MagazineNode currentNode;
        if (firstNode == null) {
            firstNode = newNode;
        }else{
            currentNode = firstNode;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void insert(Magazine magazine){
        MagazineNode newNode = new MagazineNode(magazine);
        MagazineNode currentNode;
        //for an empty list put the new node first
        if (firstNode == null) {
            firstNode = newNode;
        }else{
            currentNode = firstNode;
            //move the current node to the last one that precedes lexicographically
            while (currentNode.next != null && newNode.magazine.compareTo(currentNode.next.magazine) > 0) {
                currentNode = currentNode.next;
            }
            if(newNode.magazine.compareTo(currentNode.magazine) < 0){//the newNode becomes the first
                firstNode = newNode;
                newNode.next = currentNode;
            }else {//the newNode inserts between two others
                newNode.next = currentNode.next;
                currentNode.next = newNode;
            }
        }
    }

    public void delete(int position){
        if (firstNode == null){//for an empty list
            return;
        }
        MagazineNode temp = firstNode;

        if(position == 0){//for deleting the first node
            firstNode = temp.next;
            return;
        }
        for(int i = 0; temp != null && i < position - 1; i++){//find the node to be deleted
            temp = temp.next;
        }
        if (temp == null || temp.next == null){// If the key is not present
            return;
        }
        MagazineNode next = temp.next.next; //delete the node
        temp.next = next;
    }

    public void sort(){
        MagazineNode currentNode = firstNode;
        MagazineNode index = null;
        Magazine temp;

        if (firstNode == null) {//empty list cannot be sorted
            return;
        } else {
            while (currentNode != null) {
                // index points to the node next to current
                index = currentNode.next;

                while (index != null) {
                    if (currentNode.magazine.compareTo(index.magazine) > 0) {
                        temp = currentNode.magazine;
                        currentNode.magazine = index.magazine;
                        index.magazine = temp;
                    }
                    index = index.next;
                }
                currentNode = currentNode.next;
            }
        }
    }

    boolean search(Magazine key) {
        MagazineNode current = firstNode;
        while (current != null) {
            if (current.magazine.getTitle().equals(key.getTitle()))
                return true;
            current = current.next;
        }
        return false;
    }

    public String toString(){
        String result = "";
        MagazineNode current = firstNode;
        while(current != null){
            result += current.magazine + "\n";
            current = current.next;
        }
        return result;
    }

    private class MagazineNode{
        public Magazine magazine;
        public MagazineNode next;

        public MagazineNode(Magazine mag){
            this.magazine = mag;
            next = null;
        }
    }
}
