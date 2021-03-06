package likui;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int count;
		SAXReader reader = new SAXReader();
		// 通过read方法读取一个文件 转换成Document对象
		Document document = null;
		try {
			document = reader.read(new File("src/employees.xml"));
		} catch (DocumentException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		// 获取根节点元素对象
		Element node = document.getRootElement();
		Ways ways = new Ways();
		Scanner scr = new Scanner(System.in);
		do {
			System.out.println("欢迎使用！");
			System.out.println("请选择你要进行的操作:");
			System.out.println("1.遍历所有公司雇员信息");
			System.out.println("2.查找一个公司雇员信息");
			System.out.println("3.修改一个公司雇员信息");
			System.out.println("4.添加一个公司雇员信息");
			System.out.println("5.退出");
			count = scr.nextInt();
			switch (count) {
			case 1:
				ways.checkxml(node);
				break;
			case 2:
				System.out.println("雇员编号:");
				String name1 = scr.next();
				// ways.checkone(name,node);
				
				if (!ways.checkone(name1, node)) {
					System.out.print("没有此雇员信息!");
				}
				break;
			case 3:
				System.out.println("雇员编号:");
				String name2 = scr.next();
				try {
					if (ways.modifyexml(name2, node,document)) {
						System.out.println("修改成功!");
					} else {
						System.out.println("修改失败！");
					}
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					ways.insertxml(node,document);
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				break;
			case 5:System.out.println("谢谢使用！");
				break;
			default:
				break;
			}

		} while (count != 5);
	}

}
