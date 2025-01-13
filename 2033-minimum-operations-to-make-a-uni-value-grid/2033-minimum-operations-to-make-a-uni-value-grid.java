class Solution {
    public int minOperations(int[][] grid, int x) {
        /*
        if(grid.length == 1 && grid[0].length == 1){
            return 0;
        }
        int[] oneDepthGrid = new int[grid.length * grid[0].length];
        int index = 0;
        
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j < grid[i].length ; j++){
                oneDepthGrid[index++] = grid[i][j];
            }
        }
        Arrays.sort(oneDepthGrid);
        
        int minCount = Integer.MAX_VALUE;
        int start = 0;
        System.out.println(oneDepthGrid.length);
        if(oneDepthGrid.length > 90000 ){
            start = oneDepthGrid.length/3;
        }
        
        // for(int i=oneDepthGrid.length/3 ; i<oneDepthGrid.length - oneDepthGrid.length/2 ; i++){
        System.out.println(start);
        System.out.println(oneDepthGrid.length/3);
        System.out.println(oneDepthGrid.length - oneDepthGrid.length/2);
        for(int i=start ; i<oneDepthGrid.length/2 ; i++){
            
            // System.out.print(oneDepthGrid[i]+ ",");
            
            if(i!=0 && oneDepthGrid[i] == oneDepthGrid[i-1]){
                continue;
            }
            
            int makeCount = 0;
            for(int j=0 ; j<oneDepthGrid.length; j++){                
                int diffNum = diff(oneDepthGrid[i], oneDepthGrid[j]);
                if(diffNum == 0){
                    continue;
                }
                if(diffNum % x != 0){
                    return -1;
                }
                makeCount += (diffNum / x);  
                
                if(i!= 0 && minCount < makeCount){
                    System.out.println(i);
                    break;
                }
            }
            // System.out.println(minCount + " | " + makeCount);
            
            if(minCount > makeCount){
                minCount = makeCount;
            }
            
        }
        return minCount;
        */
        int data[]=new int[grid.length*grid[0].length];
        int k=0;
        for(int i[]:grid)
            for(int j:i)
                data[k++]=j;
        Arrays.sort(data);
        int m=data[data.length/2];
        int rem=grid[0][0]%x;
        int result=0;
        for(int i=0;i<data.length/2;i++)
        {
            if(data[i]%x!=rem)
                return -1;
            result+=(m-data[i])/x;
            
        }
        if(data[data.length/2]%x!=rem)
            return -1;
        for(int i=data.length-1;i>data.length/2;i--){
            if(data[i]%x!=rem)
                return -1;
            result+=(data[i]-m)/x;
        }
        return result;
    }
    
    public int diff(int a, int b){
        int result;
        if(a > b){
            result = a - b;
        } else {
            result = b - a;
        }
        return Math.abs(result);
    }
    
}

/*
1 10



2,4,6,8 = 20 / 4 = 5 , 2
+1 0 -1 -2

> 4

1  5  2 3 = 11 / 4 = 3 , 1
+2 +2 +1 0
> 5

1 2 3 4 = 10 / 4 = 3 , 2
2 1 0 -1

[[980,476,644,56],[644,140,812,308],[812,812,896,560],[728,476,56,812]]
84


*/


        
        /*
        int avg = sum / index;
        int minDiff = (int)Math.pow(10, 5);
        
        Arrays.sort(oneDepthGrid);
        
        for(int i=0 ; i<oneDepthGrid.length ; i++){
            int diffNum = diff(oneDepthGrid[i], avg);
            System.out.println("num : " + oneDepthGrid[i] + ", diffNum : " + diffNum);
            if(diffNum <= minDiff){
                minDiff = diffNum;
                index = i;
            }
        }
        
        
        
        
        int equalValue = oneDepthGrid[index];
        equalValue = 644;
        int returnCount = 0;
        
        System.out.println("equalValue : " + equalValue);
        
        for(int i=0 ; i<oneDepthGrid.length ; i++){
            int diffNum = diff(oneDepthGrid[i], equalValue);
            if(diffNum % x != 0){
                return -1;
            }
            returnCount += (diffNum / x);
            System.out.println("num = " + oneDepthGrid[i] + ", diff : " + diffNum + ", count : " + (diffNum/x));
        }
        
        
        
        return returnCount;
        */