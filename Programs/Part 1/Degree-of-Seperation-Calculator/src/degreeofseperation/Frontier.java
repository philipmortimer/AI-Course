/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package degreeofseperation;

/**
 *
 * @author mortimer
 */
public class Frontier {
    boolean isStack;//if true, stack else queue
    Node front[];//if stack, add to 0 element and shift right, if queue, append to end of array
    Node explored[];
    public Frontier(boolean isStack,Node[]firstNodes){
        front=firstNodes;
        this.isStack=isStack;
        explored = new Node[0];
    }
    public boolean hasFilmBeenExplored(String filmId){
        for(int exp=0;exp<explored.length;exp++){
            if(explored[exp].filmId.equals(filmId)){
                return true;
            }
        }
        return false;
    }
    public boolean isFrontEmpty(){
        return front.length==0;
    }
    public void addNode(Node add){
        if(isStack){
            Node[] n = new Node[front.length+1];
            n[0]=add;
            for(int i=1;i<n.length;i++){
                n[i]=front[i-1];
            }
            front =n;
        }else{
            Node n[]=new Node[front.length+1];
            for(int i=0;i<front.length;i++){
                n[i]=front[i];
            }
            n[n.length-1]=add;
            front=n;
        }
    }
    public Node removeNode(){
        Node rem=front[0];
        Node[]n=new Node[front.length-1];
        for(int i=1;i<front.length;i++){
            n[i-1]=front[i];
        }
        front=n;
        Node[]exp=new Node[explored.length+1];
        for(int i=0;i<explored.length;i++){
            exp[i]=explored[i];
        }
        exp[explored.length]=rem;
        explored=exp;
        return rem;
    }
}
