package findOne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FindData {

	static int num=0;
	static int qnsts3[]= {2,5,7,8,9,10,12,16,51};
	static int qnsts2[]= {1,2,3,4,5,6,8,10,11,51};
	static int dqnsts3[]= {2,5,8,7,9,10,12,16,51};
	static int dqnsts4[]= {2,5,6,8,10,51};
	static int a[]=dqnsts4;
	public void hang(List list,Set set,String url) {
		File file=new File(url);
		try {
			InputStream inputStream=new FileInputStream(file);
			BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
			String str;
			while((str=reader.readLine())!=null) {
					list.add(str);
					set.add(str);
				}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println("�����ظ�"+(list.size()-set.size()));
	}
	public void distinctSet(Set<String>set1) {
		List<String>list2=new ArrayList();
		List<String>list3=new ArrayList();
		Set<String>set=set1;
		for(String str:set) {
			String s[]=str.split("	");
			list3.add(s[0]);
			list2.add(s[1]);
		}

		for(int j=0;j<a.length;j++) {
		for(String str:list2) {
			String newstr=str.substring(1,str.length()-1);
			String s1[]=newstr.split(", ");
			
				for(int i=0;i<s1.length;i++) {
//				System.out.println(s1[i]);
				if(s1[i].equals(a[j]+"=true")) {
					num++;
				
				}
				}
				}
			System.out.println(a[j]+"=true:"+num);
			num=0;
			
		}
		System.out.println("------------------------");
	}
	public static void main(String[] args) {
		String url="E:\\Test\\data.txt";
		List<String>list=new ArrayList();//��Ŷ�ȡ������ÿһ������
		List<String>list2=new ArrayList();//���״̬��
		List<String>list3=new ArrayList();//���uid
		Set set=new HashSet();//��uidȥ��
		Set<String>set1=new HashSet();//��� ��ȡ����ÿһ�����ݣ����ظ�
		FindData finddata=new FindData();
		finddata.hang(list,set1, url);
		finddata.distinctSet(set1);
		for(String str:list) {
//			System.out.println(str);
			String s[]=str.split("	");
			set.add(s[0]);
			list3.add(s[0]);
			list2.add(s[1]);
		}
		for(int j=0;j<a.length;j++) {
		for(String str:list2) {
			String newstr=str.substring(1,str.length()-1);
			String s1[]=newstr.split(", ");
			
				for(int i=0;i<s1.length;i++) {
//				System.out.println(s1[i]);
				if(s1[i].equals(a[j]+"=true")) {
					num++;
				
				}
				}
				}
			System.out.println(a[j]+"=true:"+num);
			num=0;
			
		}
		System.out.println("ֻuid�ظ�"+(list.size()-set.size()));
	}

}
