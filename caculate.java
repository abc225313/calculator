class caculate {
	private String number;
	private char[]all={'+','-','*','/'};
	private char[] MultiplicationandDivision = {'*', '/' };
	private char[]AddorSubtract={'+','-'};
	private String temp2,temp3;
	private int[]deal;
	
	public caculate(String number) {
		if (number != null) {
			this.number = number;
		} else {
			System.out.print("請輸入");
			process('d');
		}

	}
	 int square(int a,int b){	
		return b==1?a:a*square(a, b-1);
	}

	void process(char d) {
		if(d=='d') System.exit(1); 
		int mid=0;
		String resultStr = null;
		int[]temp=new int[2];
		while (number.indexOf('^')>=0){
			mid = number.indexOf("^");
			temp=process2(mid);
			deal=deal(temp[0], temp[1], mid, number);
			resultStr = Integer.toString(square(deal[0],deal[1]));
			number = number
					.replace(number.subSequence(deal[2], deal[3]),
							resultStr);
			
		}
		for(char check:MultiplicationandDivision){
			while (number.indexOf(check)>=0){		
				if (number.indexOf("*") >= 0) {
					mid = number.indexOf("*");
					temp=process2(mid);
					deal=deal(temp[0], temp[1], mid, number);
					resultStr = Integer.toString(deal[0] *deal[1]);
					number = number
							.replace(number.subSequence(deal[2], deal[3]),
									resultStr);
				}
				if(number.indexOf("/") >= 0){
					mid=number.indexOf('/');
					temp=process2(mid);
					deal=deal(temp[0], temp[1], mid, number);
					resultStr = Integer.toString(deal[0] /deal[1]);
					number = number
							.replace(number.subSequence(deal[2], deal[3]),
									resultStr);
				}	
				
			}
		}
		for(char check:AddorSubtract){
			while (number.indexOf(check)>=0){		
				if (number.indexOf("+") >= 0) {
					mid = number.indexOf("+");
					temp=process2(mid);
					deal=deal(temp[0], temp[1], mid, number);
					resultStr = Integer.toString(deal[0] +deal[1]);
					number = number
							.replace(number.subSequence(deal[2], deal[3]),
									resultStr);
				}
				if(number.indexOf("-") >= 0){
					mid=number.indexOf('-');
					temp=process2(mid);
					deal=deal(temp[0], temp[1], mid, number);
					resultStr = Integer.toString(deal[0] -deal[1]);
					number = number
							.replace(number.subSequence(deal[2], deal[3]),
									resultStr);
				}	
				
				
			}
		}
		System.out.print(number);
	

	}
	private int[]process2(int mid){//分解
		int Fc[]=new int[2];
		stop: for (int b = mid - 1; b >= 0; b--) {
			for (int check1 = 0; check1 < all.length; check1++) {
				if (all[check1] == number.charAt(b)) {
					Fc[0]=b;
					break stop;
				}	
			}
			if (b==0) {
				Fc[0]=b;
			}

		}
		stop2: for (int e = mid + 1; e < number.length(); e++) {
			for (int check1 = 0; check1 < all.length; check1++) {
				if (all[check1] == number.charAt(e)) {
					Fc[1]=e;
					break stop2;
				}
			}
			if(e==number.length()-1){
				Fc[1]=e;
			}

		}
		return Fc;
	}
	private int[]deal(int copy,int copy2,int mid,String number){//處理成可以分解
		int[] d=new int[4];
		copy=copy==0?0:copy+1;
		copy2=copy2==number.length()-1?number.length():copy2;
		temp2 = (String) number.subSequence(copy, mid);
		temp3 = (String) number.subSequence(mid+1, copy2);
		d[0]= Integer.valueOf(temp2);
		d[1]= Integer.valueOf(temp3);
		d[2]=copy;d[3]=copy2;
		return d;
	}
}
