public class judge {

	/**
	 * 1.判断可消除数据 2.将可消除数据清空并重新赋值
	 */

	// 建立网格
	private int[][] user;

	// 建立待清零坐标组
	private int[] resetArray;

	// 待清零坐标组计数
	private int resetCount = 0;

	// 构造函数
	judge(int[][] user) {
		this.user = user;
		resetArray = new int[(user.length * user[0].length) * 2];
	}

	int getResetCount() {
		return resetCount;
	}

	// 返回网格
	int[][] getUser() {
		return user;
	}

	// 判断行中有无可消除
	void judgeRow(int i, int i1) {
		if (i > user.length - 1) {
			return;
		}
		if (user[i][i1] == user[i][i1 + 1] && user[i][i1] == user[i][i1 + 2] && user[i][i1 + 1] == user[i][i1 + 2]) {
			resetArray[resetCount] = i;
			resetArray[resetCount + 1] = i1;
			resetArray[resetCount + 2] = i;
			resetArray[resetCount + 3] = i1 + 1;
			resetArray[resetCount + 4] = i;
			resetArray[resetCount + 5] = i1 + 2;
			resetCount += 6;
		}
		if (i1 == user[0].length - 3) {
			i++;
			i1 = 0;
		}
		judgeRow(i, i1 + 1);
	}

	// 判断列中有无可消除
	void judgeCol(int i, int i1) {
		if (i1 > user[0].length - 1) {
			return;
		}
		if (user[i][i1] == user[i + 1][i1] && user[i][i1] == user[i + 2][i1] && user[i + 1][i1] == user[i + 2][i1]) {
			resetArray[resetCount] = i;
			resetArray[resetCount + 1] = i1;
			resetArray[resetCount + 2] = i + 1;
			resetArray[resetCount + 3] = i1;
			resetArray[resetCount + 4] = i + 2;
			resetArray[resetCount + 5] = i1;
			resetCount += 6;
		}
		if (i == user.length - 3) {
			i1++;
			i = 0;
		}
		judgeCol(i + 1, i1);
	}

	// 从网格中清空可消除部分
	void reset() {
		for (int i = 0; i < resetCount; i += 2) {
			user[resetArray[i]][resetArray[i + 1]] = 0;
		}
	}
	
	//数据依次下落至空值部分
	void drop(){
		for(int i=user.length-1;i>0;i--){
			for(int i1=user[0].length-1;i1>=0;i1--){
				if(user[i][i1]==0){
					user[i][i1]=user[i-1][i1];
					user[i-1][i1]=0;
				}
			}
		}
	}

	// 打印可消除部分的坐标
	void printResetArray() {
		System.out.println();
		for (int i = 0; i < resetCount; i++) {
			System.out.print(resetArray[i] + " ");
		}
		System.out.println();
		System.out.println();
	}

	// 打印网格
	void printUser() {
		System.out.print("    ");
		for (int i = 0; i < user[0].length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print("    ");
		for (int i = 0; i < user[0].length; i++) {
			System.out.print("- ");
		}
		System.out.println();
		for (int i = 0; i < user.length; i++) {
			System.out.print(i + " | ");
			for (int i1 = 0; i1 < user[0].length; i1++) {
				System.out.print(user[i][i1] + " ");
			}
			System.out.println();
		}
	}

}