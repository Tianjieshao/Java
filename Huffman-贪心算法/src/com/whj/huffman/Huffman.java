package com.whj.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Huffman implements Comparable{
    public static class Bintree{
    	public String data;
    	public String coding;
    	public Bintree Left;
    	public Bintree Right;
    	public Bintree(Bintree l,Bintree r,String data) {
    		this.Left = l;
    		this.Right = r;
    		this.data = data;
    	}
    	public String getCoding() {
    		return this.coding;
    	} 
    	public void setCoding(String coding){
    		this.coding = coding;
    	} 
    	
    }
    Bintree tree;
    float weight;
    String coding;
    public Huffman(Bintree tree,float weight){
    	this.tree = tree;
    	this.weight = weight;
    }
    @Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		float w = ((Huffman)o).weight;
    	if(this.weight<w) return -1;
    	if(this.weight==w) return 0;
    	return 1;
	}
    public static Huffman createHuffmanTree(List<Huffman> h) {
    	while(h.size()>1) {
    		Collections.sort(h);
    		Huffman h1 = h.get(0);
    		Huffman h2 = h.get(1);
    		float w = h1.weight+h2.weight;
    		Bintree b1 =h1.tree;
    		Bintree b2 =h2.tree;
    		Bintree b =new Bintree(b1,b2,"");
    		Huffman node=new Huffman(b,w);
    		
    		h.remove(0);
    		h.remove(0);
    		h.add(node);
    	}
    	return h.get(0);
    	
    }
    public static void process(Bintree node,String str){
    	if(node.Left==null) {
    		node.setCoding(str);
    		 System.out.println(node.data+": "+node.coding);
             return;  
    	}
        process(node.Left,str+"0");  
        process(node.Right,str+"1");  
    	
    }
	public static void main(String[] args) {
		List<Huffman> h=new ArrayList<Huffman>();
		Bintree b1=new Bintree(null,null,"A");
		Huffman h1=new Huffman(b1,45);
		h.add(h1);
		Bintree b2=new Bintree(null,null,"B");
		Huffman h2=new Huffman(b2,13);
		h.add(h2);
		Bintree b3=new Bintree(null,null,"C");
		Huffman h3=new Huffman(b3,12);
		h.add(h3);
		Bintree b4=new Bintree(null,null,"D");
		Huffman h4=new Huffman(b4,16);
		h.add(h4);
		Bintree b5=new Bintree(null,null,"E");
		Huffman h5=new Huffman(b5,9);
		h.add(h5);
		Bintree b6=new Bintree(null,null,"F");
		Huffman h6=new Huffman(b6,5);
		h.add(h6);
		Huffman root=createHuffmanTree(h);
		process(root.tree,"");

	}
	

}
