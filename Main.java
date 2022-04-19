public class Main {

    /* recebe um mnemonico e retorna o seu valor equivalente em hexadecimal */
    public static String mnemonicoToHexa(String mnemonico) {
        String hexa = "";

        if ( mnemonico.equals("An") ) {
            hexa = "0";

        } else if ( mnemonico.equals("nAoB") ) {
            hexa = "1";

        } else if ( mnemonico.equals("AnB") ) {
            hexa = "2";
            
        }else if ( mnemonico.equals("zeroL") ) {
            hexa = "3";

        } else if ( mnemonico.equals("nAeB") ) {
            hexa = "4";

        }else if ( mnemonico.equals("Bn") ) {
            hexa = "5";

        } else if ( mnemonico.equals("AxB") ) {
            hexa = "6";

        }else if ( mnemonico.equals("ABn") ) {
            hexa = "7";

        } else if ( mnemonico.equals("AnoB") ) {
            hexa = "8";

        }else if ( mnemonico.equals("nAxB") ) {
            hexa = "9";

        } else if ( mnemonico.equals("copiaB") ) {
            hexa = "A";

        }else if ( mnemonico.equals("AB") ) {
            hexa = "B";

        } else if ( mnemonico.equals("umL") ) {
            hexa = "C";

        }else if ( mnemonico.equals("AoBn") ) {
            hexa = "D";

        } else if ( mnemonico.equals("AoB") ) {
            hexa = "E";

        } else if ( mnemonico.equals("copiaA") ) {
            hexa = "F";

        } else {
            MyIO.println("ERRO: o mnemonico "+ mnemonico +" digitado nao existe!");

        }

        return hexa;
    }

    /* concatena as strings x, y e w para formar o comando completo em hexadecimal */
    public static String comandoHexa(String x, String y, String w) {
        String resp = x + y + w;
        return resp;
    }

    /* recebe a linha de atribuicao de W no formato "W=mnemonico;" e retorna apenas o mnemonico*/
    public static String getW ( String linha ) {
        String w = "";

        for (int i=2; i < linha.length(); i++) {

            if ( linha.charAt(i) != ';' ) {
                w += linha.charAt(i);
            }

        }
        
        return w.trim();

    }

    public static void main(String[] args) {
        String x = "";
        String y = "";
        String w = "";
        String comandos[] = new String[100];
        int indiceComandos = 0;
        String linhaArq = "";

        /* Leitura do arquivo "testeula.ula" e preenchimento do vetor de Strings com os comandos em hexadecimal*/
        Arq.openRead("testeula.ula");
            linhaArq = Arq.readLine(); /* leitura da primeira linha do arquivo "incio:" */

            while( Arq.hasNext() ) {
                linhaArq = Arq.readLine(); /* leitura da proxima linha do arquivo */
                
                /* atibui a variavel local x o valor de x presente no arquivo */
                if( linhaArq.charAt(0) == 'X' ) { 
                    x = "";
                    x += linhaArq.charAt(2);
                    
                /* atibui a variavel local y o valor de y presente no arquivo */
                } else if ( linhaArq.charAt(0) == 'Y' ) {
                    y = "";
                    y += linhaArq.charAt(2);
                    
                /* separacao do valor de w e formacao do comando completp */
                } else if ( linhaArq.charAt(0) == 'W' ) {
                    w = mnemonicoToHexa(getW( linhaArq ));
                    comandos[indiceComandos] = comandoHexa(x, y, w);
                    indiceComandos++;
                }

            }// fim while

        Arq.close();

        /* Escrita dos comandos em hexadecimal presente no vetor no arquivo "testeula.hex" */
        Arq.openWrite("testeula.hex");

            for(int i=0; i<indiceComandos; i++){
                Arq.println(comandos[i]);
            }
            
            Arq.println("xxx");

        Arq.close();
    }


}