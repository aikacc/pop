public class pop {

	// 网格长宽必须大于3
	static int[][] user = new int[5][6];

	public static void main(String[] args) {
		// 随机初始化
		for (int i = 0; i < user.length; i++) {
			for (int i1 = 0; i1 < user[0].length; i1++) {
				user[i][i1] = 1 + (int) (Math.random() * 6);
			}
		}
		newJudge();

	}

	// 消除操作
	public static void newJudge() {
		judge pop = new judge(user);
		pop.printUser();
		pop.judgeRow(0, 0);
		pop.judgeCol(0, 0);
		pop.printResetArray();
		pop.reset();
		pop.printUser();
		pop.drop();
		pop.printUser();
		user = pop.getUser();
		// 判断是否还有可消除
		if (pop.getResetCount() == 0) {
			return;
		}
		// 有则继续进行消除操作
	}

}