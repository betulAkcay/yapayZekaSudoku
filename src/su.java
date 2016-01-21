import javax.swing.text.StyledEditorKit.BoldAction;


public class su {
	
		private static int[][] sudoku = new int[9][9];
		private static int[][] sudoku1 = new int[81][81];
		private static int[][] sudoku2 = new int[81][2];
		private static int[][] sudoku3 = new  int[81][9];
		private static int[][] hash = new int[81][81];
		private static int[][]   sutun = new int[9][9];
		private static int[][]   satir = new int[9][9];
		private static int[][]   kare = new int[9][9];
		private static int[] rakamlar = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		public static int deger;
		public static void main(String[] args) {
			int kontrol =-1;
			for(int dg=0;dg<10;dg++){
				kontrol=sonuc();
				if(kontrol==0) break;
			}
			if(kontrol==0){
				for (int i11 = 0; i11 < 9; i11++) {
					for (int j = 0; j < 9; j++) {
						System.out.print(sudoku[i11][j] + " ");
					}
					System.out.println();
				}}
		}
		public static int sonuc(){
            karistir1(rakamlar);
			int kontrol2=0;
			for(int dk=0;dk<81;dk++){
				kontrol2=0;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if(sudoku[i][j]==0) kontrol2=1;
				}
				}
			if(kontrol2==0) break;
				int a=sirala();int kontrol=0,ji;
				for(int i1=0;i1<deger;i1++){ 
					for(ji=1;ji<10;ji++){
						for(int k=0;k<9;k++){
						if(sudoku1[i1][k]==ji ){kontrol=1;}}
						if(kontrol==0 ) { sudoku3[i1][0]=ji;break;}
						kontrol=0;
					}
				}
				int i1 = 0,j1 = 0;
				if(a!=0){
				if(a<9 ){ i1=a;j1=a%9;} else  { i1=a/9; j1=a%9;}
				 Boolean sonuc=uygunuMu1(i1, j1,sudoku3[a][0]);
				 if(sonuc==true){
				sudoku[i1][j1]=sudoku3[a][0];}
				 else {
						int kontrol4=0,kontrol5=0;
						for(int say=1;say<10;say++){
						for(int str=0;str<9;str++){
							if(sudoku[i1][str]==say ){kontrol4=1;break;}}
							for(int str=0;str<9;str++){
								if(sudoku[str][j1]==say ){kontrol5=1;break;}}
							int s=kutudaVarmi1(i1, j1, say);
							if(kontrol5==0 && kontrol4==0 && s!=0 ) {sudoku[i1][j1]=say;break;}
							kontrol5=0;
						    kontrol4=0;
						}
						}
				}
		}
			return kontrol2;
			
			}
		
		public static int sirala() {
			uygunuMu();
			int j;
			int max=sudoku2[0][0];
			int maxi=sudoku2[0][0];int i=0;
			 for( i=0; i<deger; i++)
		        {
				 
		            if(max<sudoku2[i][0]){
		                max = sudoku2[i][0];
		                maxi=sudoku2[i][1];
		            }
		        }
			 
			 return maxi;
		}
		
		public static void uygunuMu() {
			satirdaVarmi();
			sutundaVarmi();
			deger=0;
			int[] dizi=new int[200];
			String mesaj = null;
			int sayi=0;
			int kontrol=0,kontrol3=0;
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					if(sudoku[i][j]==0){
						for(int s1=0;s1<9;s1++){
							if(sutun[j][s1]!=0){ dizi[sayi]=sutun[j][s1];sayi++;}
						}
					for(int s2=0;s2<9;s2++){
							if(satir[i][s2]!=0){
								for(int d1=0;d1<sayi;d1++){
									if(satir[i][s2]==dizi[d1]){ kontrol++;}		
								}
								if(!(kontrol>0)){ dizi[sayi]=satir[i][s2];sayi++;}
								else kontrol=0;
							}
						}
					int bolge=kutudaVarmi(i, j);
					for(int k1=0;k1<9;k1++){
						if(kare[bolge][k1]!=0){
							for(int d3=0;d3<sayi;d3++){
								if(kare[bolge][k1]==dizi[d3]){ kontrol3++;}
							}
							if(!(kontrol3>0)){ dizi[sayi]=kare[bolge][k1];sayi++;}
							else kontrol3=0;
						}
					}
						for(int d2=0;d2<sayi;d2++){ //System.out.print(dizi[d2] + " ");
						sudoku1[deger][d2]=dizi[d2];
						}
						sudoku2[deger][0]=sayi;
						sudoku2[deger][1]=deger;
						deger++;
						sayi=0;
					}
					else {
						sudoku1[deger][0]=0;
						sudoku2[deger][0]=0;
					sudoku2[deger][1]=deger;
					deger++;}
				}}
			                           }
		

	
		private static  void satirdaVarmi() {
			int sayi = 0;
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					if(sudoku[i][j]!=0)
					{
						satir[i][sayi]=sudoku[i][j];
						
						sayi++;
					}
				}
				sayi=0;
				}
		}

		private static void sutundaVarmi() {
			int sayi = 0;
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					if(sudoku[j][i]!=0)
					{
						sutun[i][sayi]=sudoku[j][i];
						sayi++;
					}
				}
				sayi=0;
				}
		}

		private static int kutudaVarmi(int i, int j) {
			int sonuc=-1;
		
			if (0 <= i && i <= 2 && 0 <= j && j <= 2) {
				 kutuyuTara(0, 0, 2, 2,1);
				 sonuc=0;
			} else if (0 <= i && i <= 2 && 3 <= j && j <= 5) {
				kutuyuTara(0, 3, 2, 5,2);
				sonuc=1;
			} else if (0 <= i && i <= 2 && 6 <= j && j <= 8) {
				 kutuyuTara(0, 6, 2, 8,3);
				 sonuc=2;
			}
			else if (3 <= i && i <= 5 && 0 <= j && j <= 2) {
				kutuyuTara(3, 0, 5, 2,4);
				sonuc=3;
			} else if (3 <= i && i <= 5 && 3 <= j && j <= 5) {
				kutuyuTara(3, 3, 5, 5,5);
				sonuc=4;
			} else if (3 <= i && i <= 5 && 6 <= j && j <= 8) {
				kutuyuTara(3, 6, 5, 8,6);
				sonuc=5;
			}
			else if (6 <= i && i <= 8 && 0 <= j && j <= 2) {
				kutuyuTara(6, 0, 8, 2,7);
				sonuc=6;
			} else if (6 <= i && i <= 8 && 3 <= j && j <= 5) {
				 kutuyuTara(6, 3, 8, 5,8);
				 sonuc=7;
			} else if (6 <= i && i <= 8 && 6 <= j && j <= 8) {
				 kutuyuTara(6, 6, 8, 8,9);
				 sonuc=8;
			}

				return sonuc;
		}

		private static  void kutuyuTara(int i1, int j1, int i2, int j2,int sira) {

			int sonuc =0;
			for (int i = i1; i <= i2; i++){
				for (int j = j1; j <= j2; j++) {
					if (sudoku[i][j] != 0) {
						kare[sira-1][sonuc]=sudoku[i][j];
						sonuc++;
					}
				}
				sonuc=0;
			}
		}

		public static void karistir1(int[] arr1) {
			for (int i = 0; i < arr1.length; i++) {
				
				int rand1;
				int temp1;
				rand1 = (int) (Math.random() * arr1.length);
				temp1 = arr1[i];
				arr1[i] = arr1[rand1];
				arr1[rand1] = temp1;
				
			}
			for (int i =0; i < arr1.length; i++){
				sudoku[0][i] = arr1[i];
			   // sudoku[3][i] = arr2[i];
		}
			karistir2(arr1);

	}
		public static void karistir2(int[] arr1) {
			int kontrol=0;
			for (int i = 0; i < arr1.length; i++) {
				int rand1;
				int temp1;
				rand1 = (int) (Math.random() * arr1.length);
				temp1 = arr1[i];
				arr1[i] = arr1[rand1];
				arr1[rand1] = temp1;
				}
			for (int i = 0; i < arr1.length; i++){
				if(sudoku[0][i]==arr1[i]){
					kontrol=1;
				}
		        }
               if(kontrol==1){ karistir2(arr1);}
               else { for (int i = 0; i < arr1.length; i++){
				sudoku[3][i]=arr1[i];//
				} karistir3(arr1);}
	}
		public static void karistir3(int[] arr1) {
			int kontrol=0;
			for (int i = 0; i < arr1.length; i++) {
				int rand1;
				int temp1;
				rand1 = (int) (Math.random() * arr1.length);
				temp1 = arr1[i];
				arr1[i] = arr1[rand1];
				arr1[rand1] = temp1;
				}
			for (int i = 0; i < arr1.length; i++){
				if(sudoku[3][i]==arr1[i] || sudoku[0][i]==arr1[i]){
					kontrol=1;
				}
		        }
               if(kontrol==1){ karistir3(arr1);}
               else for (int i = 0; i < arr1.length; i++){
				sudoku[6][i]=arr1[i];
				}
	}
		public static boolean uygunuMu1(int i, int j, int sayi) {

			boolean sonuc = false;

			int metot1 = 0, metot2 = 0, metot3 = 0;

			metot1 = satirdaVarmi1(i, sayi);
			if (metot1 == 1) {
				metot2 = sutundaVarmi1(j, sayi);
				if (metot2 == 1)
					metot3 = kutudaVarmi1(i, j, sayi);
			}

			if ((metot1 * metot2 * metot3) == 0) {
				sonuc = false;
			} else {
				sonuc = true;
			}

			return sonuc;
		}

		private static int satirdaVarmi1(int i, int sayi) {
			int sonuc = 0;
			for (int k = 0; k < 9; k++)
				if (sudoku[i][k] == sayi) {
					sonuc = 0;
					break;
				} else
					sonuc = 1;
			return sonuc;
		}

		private static int sutundaVarmi1(int j, int sayi) {
			int sonuc = 0;
			for (int k = 0; k < 9; k++)
				if (sudoku[k][j] == sayi) {
					sonuc = 0;
					break;
				} else
					sonuc = 1;
			return sonuc;
		}

		private static int kutudaVarmi1(int i, int j, int sayi) {

			int sonuc = 1;
			if (0 <= i && i <= 2 && 0 <= j && j <= 2) {
				sonuc = kutuyuTara1(0, 0, 2, 2, sayi);

			} else if (0 <= i && i <= 2 && 3 <= j && j <= 5) {
				sonuc = kutuyuTara1(0, 3, 2, 5, sayi);
			} else if (0 <= i && i <= 2 && 6 <= j && j <= 8) {
			}
			else if (3 <= i && i <= 5 && 0 <= j && j <= 2) {
				sonuc = kutuyuTara1(3, 0, 5, 2, sayi);
			} else if (3 <= i && i <= 5 && 3 <= j && j <= 5) {
				sonuc = kutuyuTara1(3, 3, 5, 5, sayi);
			} else if (3 <= i && i <= 5 && 6 <= j && j <= 8) {
				sonuc = kutuyuTara1(3, 6, 5, 8, sayi);
			}
			else if (6 <= i && i <= 8 && 0 <= j && j <= 2) {
				sonuc = kutuyuTara1(6, 0, 8, 2, sayi);
			} else if (6 <= i && i <= 8 && 3 <= j && j <= 5) {
				sonuc = kutuyuTara1(6, 3, 8, 5, sayi);
			} else if (6 <= i && i <= 8 && 6 <= j && j <= 8) {
				sonuc = kutuyuTara1(6, 6, 8, 8, sayi);
			}

			return sonuc;
		}

		private static int kutuyuTara1(int i1, int j1, int i2, int j2, int sayi) {

			int sonuc = 1;
			for (int i = i1; i <= i2; i++)
				for (int j = j1; j <= j2; j++) {
					if (sudoku[i][j] == sayi) {
						sonuc = 0;
						break;
					}
				}
			return sonuc;
		}

		public static void karistir(int[] arr) {

			for (int i = 0; i < arr.length; i++) {

				int randNum;
				int temp;

				randNum = (int) (Math.random() * arr.length);
				temp = arr[i];
				arr[i] = arr[randNum];
				arr[randNum] = temp;
			}

			for (int i = 0; i < arr.length; i++)
				sudoku[0][i] = arr[i];

		}

	}




