public class IPv4AutoScanIP {
	final static int UseBit=256;//位元
	/**
	 * 作者：陳毓凱
	 * http://1003b.vip.gamebase.com.tw/v1/1-14/1-14-0-1-2-1.htm
	 * 時間：2017/3/2/01:00洗澡時想到
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String MustAutoScanMark="X";//自動掃描記號
		String[] IPv4Ary=new String[]{"127",MustAutoScanMark,"192",MustAutoScanMark};//IP陣列
		int[] AutoScanColAry=new int[IPv4Ary.length];//自動掃描位元陣列
		int AutoScanColCountNumber=0;//自動掃描位元統計
		for(int i=0;i<IPv4Ary.length;i++){
			if(IPv4Ary[i].equals(MustAutoScanMark)){//檢查是否自動掃描
				AutoScanColCountNumber++;//位元增加
				AutoScanColAry[i]=AutoScanColCountNumber;//紀錄位元位置從左到右從1開始遞增
			}else{
				AutoScanColAry[i]=0;//不用掃描則填0
			}
		}
		
		long LoopRunTime=(long) Math.pow(UseBit, AutoScanColCountNumber);//計算迴圈掃描次數(任何數的0次方等於1)
		
			for(long i=0;i<LoopRunTime;i++){//開始掃描
				String OutputIP="IP:";
					for(int j=0;j<IPv4Ary.length;j++){
						String ThisColIP="";//本欄代表IP					
						if(IPv4Ary[j].equals(MustAutoScanMark)){//檢查是否自動掃描
							ThisColIP=TenBitChange(i,AutoScanColAry[j],AutoScanColCountNumber);//換算欄位代表IP值
						}else{
							ThisColIP=IPv4Ary[j];//不用掃描直接輸出本欄代表IP
						}
						OutputIP+=ThisColIP+".";//累加IP
					}				
				System.out.println(OutputIP);//印出IP
			}
	}
	public static String TenBitChange(long BigNumber,int NowCol,int TotalCol){//換算欄位代表IP值(計步器,紀錄位元位置從左到右從1開始遞增,掃描位元統計)
		int DivisionCount=TotalCol-NowCol;//計算本位元需要除幾次
		long DivisionNumber=(long)Math.pow(UseBit, DivisionCount);//算出除數(任何數的0次方等於1)
		long output=BigNumber/DivisionNumber;//開始除法
		output%=UseBit;//避免溢位換算餘數輸出最保險
		return String.valueOf(output);//轉換字串輸出
	}
}
