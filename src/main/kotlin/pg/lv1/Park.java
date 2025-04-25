package pg.lv1;

class Park {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length; j++){
                // 한칸씩 이동하면서 빈곳 찾으면
                if("-1".equals(park[i][j])){
                    int[] nowPos = {i, j};
                    //매트 끼워보기(큰것부터)
                    for (int k = mats.length - 1; k >= 0; k--){
                        if(mats[k] > answer)
                            if(matCheck(mats[k], nowPos, park))
                                if(answer < mats[k])
                                    answer = mats[k];
                    }
                }
            }
        }

        return answer;
    }

    private boolean matCheck(int matLength, int[] startPos, String[][] park){
        if(startPos[0] + matLength > park.length) return false;

        for(int i = startPos[0]; i < startPos[0] + matLength; i++){
            if(startPos[1] + matLength > park[0].length) return false;

            for(int j = startPos[1]; j < startPos[1] + matLength; j++)
                if(!"-1".equals(park[i][j])) return false;
        }

        return true;
    }
}