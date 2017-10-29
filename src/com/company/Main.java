package com.company;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("输入时间戳：");
		long data = input.nextLong();
		data = data + 8 * 3600;    					//从北京时间1970.01.01 0:00开始
		int day = (int) data / 86400;   			//一共有多少天
		int rest_s = (int) data % 86400;			//不足一天的秒数
		int hour = rest_s / 3600;
		int minite = (rest_s - hour * 3600) / 60;
		rest_s = (int) (data % 60);
		int year = day / 1461;						//有多少个4年
		int rest_day = day % 1461;					//不足4年的天数
		int month = 0, flag = 0;
		year = 1970 + 4 * year;
		while (true) {
			if ((year % 4 == 0 && year / 100 != 0) || year % 400 == 0) {
				if (rest_day >= 366) {
					rest_day -= 366;
					year++;
				} else {
					flag = 1;
					break;
				}
			} else if (rest_day >= 365) {
				rest_day -= 365;
				year++;
			} else break;
		}

		for (int i = 1, j = 1; rest_day >= 31; i++) {
			if (i == 2) {
				if (flag == 1) rest_day -= 29;
				else rest_day -= 28;
			} else {
				if (j == 1 && i != 7) {
					rest_day -= 31;
					j = 0;
				} else {
					rest_day -= 30;
					j = 1;
				}
			}
			month = i + 1;
		}
		System.out.println(year + "年" + month + "月" + rest_day + "日" + hour + ':' + minite + ':' + rest_s);
	}
}