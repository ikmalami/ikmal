package linkedlist;

public class Linked {
    NodeList firstNode;
    NodeList lastNode;
    
    Linked(){
        firstNode = null;
        lastNode = null;
    }
    void tambahDepan(int angka){
        if(firstNode ==null){
            NodeList newNode = new NodeList(angka);
            firstNode = newNode;
            lastNode = newNode;
        }else{
            firstNode = new NodeList(angka, firstNode);
        }
    }
    
    void tambahBelakang(int angka, NodeList next){
        if(firstNode==null && lastNode ==null){
            NodeList newNode = new NodeList(angka);
            firstNode = newNode;
            lastNode = newNode;
        }else{
            lastNode.nextNode = new NodeList(angka);
            lastNode = lastNode.nextNode;        
        }
    }
    void cetak(){
        NodeList cekNode = firstNode;
        while (cekNode!=null){
            System.out.printf("%s ", cekNode.getNilai());
            cekNode = cekNode.getNext();
        }
    }
    int hapusDepan(){
        NodeList cekNode = firstNode;
        int nilai = firstNode.getNilai();
        if(cekNode != null){
            if(firstNode == lastNode){
                firstNode = lastNode = null;
            } else{
                firstNode = firstNode.nextNode;
            }
        }
        return nilai;
    }
    int hapusBelakang(){
        NodeList cekNode = lastNode;
        int nilai = lastNode.getNilai();
        if(cekNode != null){
            if(firstNode == lastNode){
                firstNode = lastNode = null;
            } else{
                NodeList sblmNodeAkhir = firstNode;
                while(sblmNodeAkhir.nextNode!=lastNode){
                    sblmNodeAkhir=sblmNodeAkhir.nextNode;
                }
                lastNode = sblmNodeAkhir;
                sblmNodeAkhir.nextNode = null;
            }
        }
        return nilai;
    }
    
     void find(int angka) {
        NodeList cekNode = firstNode;
        int posisi = -1;
        int counter = 1;
        while(cekNode != null) {
            if(cekNode != lastNode){
                if(cekNode.getNilai()==angka){
                    System.out.print(counter + " ");
                    posisi =1;
                    counter = counter +1;
                }else{
                    counter = counter +1;
                }
                cekNode = cekNode.getNext();
            }else
                break;
        }
        if(posisi==-1){
            System.out.println("Tidak ada");
        }
    }
    public void hapusdua(){
        NodeList cekNode = firstNode;
        if(firstNode ==null || firstNode == lastNode){
            System.out.println("Tidak ada node");
            if(firstNode==lastNode){
                System.out.println("Node hanya satu");
            }
        } else{
            firstNode = new NodeList(firstNode.getNilai(), firstNode.getNext().getNext());
        }
        System.out.print("Setelah hapus node 2 : ");
        cetak();
    }
}
