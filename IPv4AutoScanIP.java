public class IPv4AutoScanIP {
	final static int UseBit=256;//�줸
	/**
	 * �@�̡G������
	 * http://1003b.vip.gamebase.com.tw/v1/1-14/1-14-0-1-2-1.htm
	 * �ɶ��G2017/3/2/01:00�~���ɷQ��
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String MustAutoScanMark="X";//�۰ʱ��y�O��
		String[] IPv4Ary=new String[]{"127",MustAutoScanMark,"192",MustAutoScanMark};//IP�}�C
		int[] AutoScanColAry=new int[IPv4Ary.length];//�۰ʱ��y�줸�}�C
		int AutoScanColCountNumber=0;//�۰ʱ��y�줸�έp
		for(int i=0;i<IPv4Ary.length;i++){
			if(IPv4Ary[i].equals(MustAutoScanMark)){//�ˬd�O�_�۰ʱ��y
				AutoScanColCountNumber++;//�줸�W�[
				AutoScanColAry[i]=AutoScanColCountNumber;//�����줸��m�q����k�q1�}�l���W
			}else{
				AutoScanColAry[i]=0;//���α��y�h��0
			}
		}
		
		long LoopRunTime=(long) Math.pow(UseBit, AutoScanColCountNumber);//�p��j�鱽�y����(����ƪ�0���赥��1)
		
			for(long i=0;i<LoopRunTime;i++){//�}�l���y
				String OutputIP="IP:";
					for(int j=0;j<IPv4Ary.length;j++){
						String ThisColIP="";//����N��IP					
						if(IPv4Ary[j].equals(MustAutoScanMark)){//�ˬd�O�_�۰ʱ��y
							ThisColIP=TenBitChange(i,AutoScanColAry[j],AutoScanColCountNumber);//�������N��IP��
						}else{
							ThisColIP=IPv4Ary[j];//���α��y������X����N��IP
						}
						OutputIP+=ThisColIP+".";//�֥[IP
					}				
				System.out.println(OutputIP);//�L�XIP
			}
	}
	public static String TenBitChange(long BigNumber,int NowCol,int TotalCol){//�������N��IP��(�p�B��,�����줸��m�q����k�q1�}�l���W,���y�줸�έp)
		int DivisionCount=TotalCol-NowCol;//�p�⥻�줸�ݭn���X��
		long DivisionNumber=(long)Math.pow(UseBit, DivisionCount);//��X����(����ƪ�0���赥��1)
		long output=BigNumber/DivisionNumber;//�}�l���k
		output%=UseBit;//�קK���촫��l�ƿ�X�̫O�I
		return String.valueOf(output);//�ഫ�r���X
	}
}
