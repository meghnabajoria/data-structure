class StockSpanner {
List<int[]> list = new ArrayList<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        if(list.isEmpty()) {
            int[] temp = new int[] {price, 1};
            list.add(temp);
        }
        else {
            int[] lastElem = list.get(list.size() - 1);
           if(lastElem[0] <= price) {
               int span = 1;
               while(lastElem[0] <= price) {
                    list.remove(list.size() - 1);
                    span += lastElem[1];
                    if(!list.isEmpty()) 
                        lastElem = list.get(list.size() - 1);
                   else
                       break;
                 
               }
               int[] newElem = new int[] {price, span};
               list.add(newElem); 
            }
            else {
                int[] arr = new int[] {price,1};
                list.add(arr);                    
            }
        }
         return list.get(list.size() - 1)[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */