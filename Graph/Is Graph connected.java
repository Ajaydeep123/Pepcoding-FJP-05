public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
        int count=0;
        boolean[] visited=new boolean[vtces];
      // write your code here
      for(int i=0;i<vtces;i++){
          if(visited  [i]==false){
              count++;
              getComponents(graph,i,visited); 
          }
      }
      if(count==1) System.out.println("true");
      else System.out.println("false");
   }
   
   
   
   
   public static void getComponents(ArrayList<Edge>[]graph,int src,boolean []visited){
       
       visited[src]=true;
       for(Edge e:graph[src]){
           int nbr=e.nbr;
           if(visited[nbr]==false){
               getComponents(graph,nbr,visited);
           }
       }
   }
   
