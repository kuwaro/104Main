import java.util.Random;
import java.util.Scanner;
public class Card {
	public int cardType,cardNumber;
	static int cardList[][]=new int[4][13];//使用済みのカードを登録する
	static int selectedList[][]=new int[4][13];//選択済みのカードを登録する


	Card(){
		Random rd = new Random();
		for(;;) {
		cardType=rd.nextInt(4)+1;
		cardNumber=rd.nextInt(13)+1;
		if(cardList[cardType-1][cardNumber-1]==0)
			break;
		}
		cardList[cardType-1][cardNumber-1]=1;

	}

	//選択できるカードを表示
		public static void cardDisp(Card card[]){
			int marks[]=new int[5];
			int numbers[]=new int[5];

			//カードのマークを登録
			for(int i=0;i<card.length;i++)
			marks[i]=card[i].cardType;

			//カードの番号を登録
			for(int i=0;i<card.length;i++)
			numbers[i]=card[i].cardNumber;

			System.out.print("   ");

			//マークを表示
			for(int i=0;i<(marks.length);i++) {
				//1:スペード 2:ハート 3:クローバー 4:ダイヤ
				if(marks[i]==1) {
					System.out.print("| ♠︎ | ");
				}else if(marks[i]==2) {
					System.out.print("| ❤ | ");
				}else if(marks[i]==3) {
					System.out.print("| ♣︎️︎️ | ");
				}else if(marks[i]==4){
					System.out.print("| ♦︎️️ | ");
				}else {
					System.out.print("      ");
				}
			}
			System.out.println();
			System.out.print("   ");

			for(int i=0;i<(numbers.length);i++) {
				if(numbers[i]==1) {
					System.out.print("| A | ");
				}else if(numbers[i]==11) {
					System.out.print("| J | ");
				}else if(numbers[i]==12) {
					System.out.print("| Q | ");
				}else if(numbers[i]==13) {
					System.out.print("| K | ");
				}else if(numbers[i]==10){
					System.out.print("| 10| ");
				}else if(numbers[i]==0){
					System.out.print("      ");
				}else{
					System.out.print("| "+numbers[i]+" | ");
				}
			}
			System.out.println();
			System.out.println();
			System.out.print("   ");

			for(int i=1;i<=5;i++) {
				System.out.print("  "+i+"   ");
			}
System.out.println();
System.out.println();


		}

		//残りのカードのリストを表示
		public static void listDisp() {
			int typeCount=0;
			for(int j=0;j<4;j++,typeCount++) {
				switch(typeCount) {
				case 0:System.out.print("♠︎ ︎");
				break;
				case 1:System.out.print("❤ ︎");
				break;
				case 2:System.out.print("♣ ︎");
				break;
				default:System.out.print("♦︎ ︎");
				break;
				}

			for(int i=0;i<13;i++) {
			if(selectedList[j][i]==1) {
				if(i==9){
				System.out.print("  ");//使い終わったやつは表示されない
				}else {
					System.out.print(" ");
					}
			}else {
				if(i+1==1) {
					System.out.print("A");
				}else if(i+1==11) {
					System.out.print("J");
				}else if(i+1==12) {
					System.out.print("Q");
				}else if(i+1==13) {
					System.out.print("K");
				}else{
					System.out.print(i+1);
				}
			}

			}
			switch(typeCount) {
			case 0:System.out.print(" ♠︎");
			break;
			case 1:System.out.print(" ❤");
			break;
			case 2:System.out.print(" ♣︎");
			break;
			default:System.out.print(" ♦︎︎");
			break;
			}
			System.out.println();
			}
			System.out.println();

		}

		//選択されたカードを表示
		public static void lastDisp(Card card) {

			System.out.print("               ");
			if(card==null){
				System.out.print("      ");
			}else if(card.cardType==1) {
				System.out.print("| ♠︎︎︎️ | ");
			}else if(card.cardType==2) {
				System.out.print("| ❤︎️ | ");
			}else if(card.cardType==3) {
				System.out.print("| ♣︎️ | ");
			}else {
				System.out.print("| ♦︎️️ | ");
			}
			System.out.println();
			System.out.print("               ");
			if(card==null){
				System.out.print("      ");
			}else if(card.cardNumber==1) {
				System.out.print("| A | ");
			}else if(card.cardNumber==11) {
				System.out.print("| J | ");
			}else if(card.cardNumber==12) {
				System.out.print("| Q | ");
			}else if(card.cardNumber==13) {
				System.out.print("| K | ");
			}else if(card.cardNumber==10){
				System.out.print("| 10|");
			}else if(card.cardNumber==0){
				System.out.print("      ");
			}else{
				System.out.print("| "+card.cardNumber+" | ");
			}
			System.out.println();
			System.out.println();
		}

		//カードが繋げられるかチェック
		public boolean cardCheck(Card lastCard) {
			if(lastCard==null) {
				return true;
			}else if(lastCard.cardType==this.cardType
				||lastCard.cardNumber==this.cardNumber){
				return true;
			}else {
				return false;
			}

		}

		//選択されたカードをリストに登録
		public static void selected(Card selected) {
			selectedList[selected.cardType-1][selected.cardNumber-1]=1;
		}

		//win枚数を計算
		public static int winCal(int score,int bet) {
			if(score<10) {
				return 0;
			}else if(score>=10&&score<=13){
				return bet;
			}else if(score>=14&&score<=16) {
				return bet*2;
			}else if(score>=17&&score<=19) {
				return bet*3;
			}else if(score>=20&&score<=22){
				return bet*4;
			}else if(score>=23&&score<=25) {
				return bet*6;
			}else if(score>=26&&score<=28) {
				return bet*8;
			}else if(score>=29&&score<=30) {
				return bet*10;
			}else if(score>=31&&score<=32){
				return bet*12;
			}else if(score>=33&&score<=34) {
				return bet*14;
			}else if(score>=35&&score<=36) {
				return bet*16;
			}else if(score>=37&&score<=38) {
				return bet*18;
			}else if(score>=39&&score<=40) {
				return bet*20;
			}else if(score>=41&&score<=42) {
				return bet*22;
			}else if(score>=43&&score<=50) {
				return bet*(score-38)*5;
			}else if(score==51) {
				return bet*80;
			}else if(score>=52&&score<=82) {
				return bet*((score-52)*10+100);
			}else if(score>=83&&score<=92) {
				return bet*((score-82)*20+400);
			}else if(score>=93&&score<=98) {
				return bet*((score-92)*50+600);
			}else if(score>=99&&score<=101) {
				return bet*((score-98)*100+900);
			}else if(score>=102&&score<=103) {
				return bet*((score-101)*200+1200);
			}else if(score==104) {
				return bet*2000;
			}else {
				return 0;
			}
		}
		//リストを初期化
		public static void listReset() {
			for(int j=0;j<4;j++) {
				for(int i=0;i<13;i++) {
					cardList[j][i]=0;
					selectedList[j][i]=0;
				}
			}
		}

		//ダブルアップゲーム
		@SuppressWarnings("resource")
		public static int DoubleUp(Card card[],int win) {
			while(true) {
			listReset();
			System.out.println();
			int marks[]=new int[5];
			int numbers[]=new int[5];

			//カードのマークを登録
			for(int i=0;i<card.length;i++)
			marks[i]=card[i].cardType;

			//カードの番号を登録
			for(int i=0;i<card.length;i++)
			numbers[i]=card[i].cardNumber;

			System.out.print("   ");

			if(marks[0]==1) {
				System.out.print("| ♠︎ | ");
			}else if(marks[0]==2) {
				System.out.print("| ❤ | ");
			}else if(marks[0]==3) {
				System.out.print("| ♣︎️︎️ | ");
			}else if(marks[0]==4){
				System.out.print("| ♦︎️️ | ");
			}else {
				System.out.print("      ");
			}

			for(int i=0;i<4;i++) {
				System.out.print("| ? | ");
		}
			System.out.println();
			System.out.print("   ");

			if(numbers[0]==1) {
				System.out.print("| A | ");
			}else if(numbers[0]==11) {
				System.out.print("| J | ");
			}else if(numbers[0]==12) {
				System.out.print("| Q | ");
			}else if(numbers[0]==13) {
				System.out.print("| K | ");
			}else if(numbers[0]==10){
				System.out.print("| 10| ");
			}else if(numbers[0]==0){
				System.out.print("      ");
			}else{
				System.out.print("| "+numbers[0]+" | ");
			}
			for(int i=0;i<4;i++) {
				System.out.print("| ? | ");
			}

			System.out.println();
			System.out.println();
			System.out.print("         ");

			for(int i=1;i<=4;i++) {
				System.out.print("  "+i+"   ");
			}
			System.out.println();
			System.out.print("Select CardNumber:");
			Scanner sc = new Scanner(System.in);
			int ans=sc.nextInt();
			System.out.println();
			cardDisp(card);
			if(numbers[ans]>=numbers[0]) {
				win*=2;
				System.out.println("WINNER!");
				System.out.println("Your win:"+win);
				System.out.println();
				System.out.print("Do you challenge again?(Yes:1,No:2):");
			ans=sc.nextInt();
			if(ans==1) {
				continue;
			}else {
				break;
			}
			}else {
				System.out.println("GAME OVER");
				win=0;
			}
			}
			return win;
		}
}