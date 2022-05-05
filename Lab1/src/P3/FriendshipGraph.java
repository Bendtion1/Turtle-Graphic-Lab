package P3;

import java.util.ArrayList;

public class FriendshipGraph {
       final int MAXN=200;
       int[][]  people =new int[MAXN][MAXN];
       int[][]  dis = new int[MAXN][MAXN];
       ArrayList<Person> pername = new ArrayList<Person>();
       
       public void addVertex(Object obj)
       {
    	   Person temp = (Person) obj;
    	   for (int i = 0; i < pername.size(); i++) {
   			if (pername.get(i).name.equalsIgnoreCase(temp.name))
   				throw new RuntimeException("Each person has a unique name");
   		        }
   	    	this.pername.add(temp);
       }
       public void addEdge(Object obj1,Object obj2)
       {
    	   Person temp1 = (Person) obj1;
    	   Person temp2 = (Person) obj2;
    	   boolean flag1 =false ;
    	   boolean flag2 =false ;
    	   int pobj1=-1,pobj2=-1;
    	   for(int i=0;i<pername.size();i++) {
    		   if(pername.contains(temp1))
    		   {
    			   flag1 =true ;
    			   pobj1= pername.indexOf(temp1);
    			   
    		   }
    	   }
    	   for(int i=0;i<pername.size();i++) {
    		   if(pername.contains(temp2))
    		   {
    			   flag2 =true ;
    			   pobj2= pername.indexOf(temp2);
    		   }
    	   }
    	   if(flag1&&flag2) people[pobj1][pobj2]=1;
    	   else throw new  RuntimeException("We don't have such a person");
       }
       public int getDistance(Object obj1, Object obj2)
       {
    	   Person temp1 = (Person) obj1;
    	   Person temp2 = (Person) obj2;
    	   boolean flag1 =false ;
    	   boolean flag2 =false ;
    	   int pobj1=-1,pobj2=-1;
    	   for(int i=0;i<pername.size();i++)
    	   {
    		   for(int j=0;j<pername.size();j++)
    		   {
    			   if(i==j) dis[i][j]=0;
    			   else if(people[i][j]==1) dis[i][j]=1;
    			   else dis[i][j]=9999;
    			   
    		   }
    	   }
    	   for(int i=0;i<pername.size();i++) {
    		   if(pername.contains(temp1))
    		   {
    			   flag1 =true ;
    			   pobj1= pername.indexOf(temp1);
    			   
    		   }
    	   }
    	   for(int i=0;i<pername.size();i++) {
    		   if(pername.contains(temp2))
    		   {
    			   flag2 =true ;
    			   pobj2= pername.indexOf(temp2);    			   
    		   }
    	   }
    	   if(flag1&&flag2)
    	   {
    		   if(pobj1==pobj2)
    			   return 0;
    		   else {
    			   for(int k=0;k<pername.size();k++){
    				   for(int i=0;i<pername.size();i++){
    					   for(int j=0;j<pername.size();j++){
    						   if (i != j && dis[i][j] > dis[i][k] + dis[k][j])
                                    dis[i][j] = dis[i][k] + dis[k][j];
    					   }
    				   }
    			   }
    		   }
    		   if(dis[pobj1][pobj2]!=9999) return dis[pobj1][pobj2];
    		   else return -1;
    	   }
    	   else throw new  RuntimeException("We don't have such a person");
       }
       
}
