package trabalhoconclusaojava;

/**
 *
 * @author 291021
 */
import Classes.Ferramentas;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Control {

    public Control() {
    }
    
    public int verificaIDsem(ArrayList array, Ferramentas ferramenta, Ferramentas ferramenta1, int y){
        int igual=0;
        for(int x = 0; x < array.size(); x++){
            ferramenta1 = (Ferramentas) array.get(x);
            if(ferramenta.getID() == ferramenta1.getID() && y != x){
                igual++;
            }
        }
        return igual;
    }
    
    public int verificaID(ArrayList array, Ferramentas ferramenta, Ferramentas ferramenta1){
        int igual=0;
        for(int x = 0; x < array.size(); x++){
            ferramenta1 = (Ferramentas) array.get(x);
            if(ferramenta.getID() == ferramenta1.getID()){
                igual++;
            }
        }
        return igual;
    }
    
    public int tryInt(String text){
        Boolean loop;
        int x = 0;
        do{
            try{
                loop = false;
                x = Integer.parseInt(JOptionPane.showInputDialog(text));
            } catch(Exception e){
                loop = true;
            }
        }while(loop == true);
        return x;
    }
    
    public int tryInt(String text, int int1){
        Boolean loop;
        int x = 0;
        do{
            try{
                loop = false;
                x = Integer.parseInt(JOptionPane.showInputDialog(text, int1));
            } catch(Exception e){
                loop = true;
            }
        }while(loop == true);
        return x;
    }
    
    public float tryFloat(String text){
        Boolean loop;
        float x = 0;
        do{
            try{
                loop = false;
                x = Float.parseFloat(JOptionPane.showInputDialog(text));
            } catch(Exception e){
                loop = true;
            }
        }while(loop == true);
        return x;
    }
    
    public float tryFloat(String text, float float1){
        Boolean loop;
        float x = 0;
        do{
            try{
                loop = false;
                x = Float.parseFloat(JOptionPane.showInputDialog(text, float1));
            } catch(Exception e){
                loop = true;
            }
        }while(loop == true);
        return x;
    }
    
    public void init(){
        ArrayList array = new ArrayList();
        array = Util.le();
        Ferramentas ferramenta = new Ferramentas();
        Ferramentas ferramenta1 = new Ferramentas();
        int esc, igual, exist, ex, esc2;
        int int1;
        float float1;
        do{
            esc = tryInt("Escolha uma opção: \n"
            + "1 - Inserir ferramenta\n"
            + "2 - Remover ferramenta\n"
            + "3 - Listar ferramentas\n"
            + "4 - Editar ferramenta\n"
            + "0 - Sair");
            switch(esc){
                case 0:
                    Util.grava(array);
                    JOptionPane.showMessageDialog(null, "Programa finalzado");
                    break;
                case 1:
                    ferramenta = new Ferramentas();
                    ferramenta.setID(tryInt("Digite um ID: "));
                    while(ferramenta.getID() <= 0){
                        ferramenta.setID(tryInt("ID inválido, digite um ID maior que 0: "));
                    }
                    igual = verificaID(array, ferramenta, ferramenta1);
                    while(igual != 0){
                        ferramenta.setID(tryInt("ID já utilizado, digite um novo ID: "));
                        while(ferramenta.getID() <= 0){
                            ferramenta.setID(tryInt("ID inválido, digite um ID maior que 0: "));
                        }
                        igual = verificaID(array, ferramenta, ferramenta1);
                    }
                    ferramenta.setItem(JOptionPane.showInputDialog("Digite o item: "));
                    ferramenta.setMarca(JOptionPane.showInputDialog("Digite a marca: "));
                    ferramenta.setCor(JOptionPane.showInputDialog("Digite a cor: "));
                    ferramenta.setPeso(tryFloat("Digite o peso: "));
                    ferramenta.setFabricante(JOptionPane.showInputDialog("Digite o fabricante: "));
                    ferramenta.setAno_de_Fabricacao(tryInt("Digite o ano de fabricação: "));
                    ferramenta.setPreco(tryFloat("Digite o preço da ferramenta: "));
                    ferramenta.setIsolado(JOptionPane.showInputDialog("Digite se o objeto é isolado (s/n): ").charAt(0));
                    while(ferramenta.getIsolado() != 's' && ferramenta.getIsolado() != 'S' && ferramenta.getIsolado() != 'n' && ferramenta.getIsolado() != 'N'){
                        ferramenta.setIsolado(JOptionPane.showInputDialog("Inválido, digite novamente (s/n): ").charAt(0));
                    }
                    array.add(ferramenta);
                    break;
                case 2:
                    if(array.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Nenhuma ferramenta salva");
                    } else{
                        ex = tryInt("Digite o ID da ferramenta para exclusão: ");
                        exist=0;
                        while(exist == 0){
                            for(int x = 0; x < array.size(); x++){
                                ferramenta1 = (Ferramentas) array.get(x);
                                if(ex == ferramenta1.getID()){
                                    exist++;
                                    array.remove(x);
                                }
                            }
                            if(exist == 0){
                                ex = tryInt("ID não encontrado, digite outro ID ou 0 para cancelar exclusão: ");
                                if(ex == 0){break;}
                            }
                        }
                    }
                break;
                case 3:
                    if(array.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Nenhuma ferramenta salva");
                    } else{
                        String msg = "Ferramentas: \n";
                        for(int x=0; x < array.size(); x++){
                            ferramenta1 = (Ferramentas) array.get(x);
                            msg = msg + "ID: " + ferramenta1.getID() + "\n";
                            msg = msg + "Item: " + ferramenta1.getItem() + "\n";
                            msg = msg + "Marca: " + ferramenta1.getMarca() + "\n";
                            msg = msg + "Cor: " + ferramenta1.getCor() + "\n";
                            msg = msg + "Peso: " + ferramenta1.getPeso() + "\n";
                            msg = msg + "Fabricante: " + ferramenta1.getFabricante() + "\n";
                            msg = msg + "Ano de fabricação: " + ferramenta1.getAno_de_Fabricacao() + "\n";
                            msg = msg + "Preço: " + ferramenta1.getPreco()+ "\n";
                            msg = msg + "Isolado (s/n): " + ferramenta1.getIsolado()+ "\n";
                            msg = msg + "\n --------------------------------- \n";
                        }
                        JOptionPane.showMessageDialog(null, msg);
                    }
                    break;
                case 4:
                    int y=0;
                    if(array.isEmpty()){JOptionPane.showMessageDialog(null, "Nenhuma ferramenta salva"); break;}
                    ex = tryInt("Digite o ID da ferramenta para editar: ");
                    do{
                        igual=0;
                        for(int x = 0; x < array.size(); x++){
                            ferramenta = (Ferramentas) array.get(x);
                            if(ex == ferramenta.getID()){
                                y = x;
                                igual++;
                                break;
                            }
                        }
                        if(igual == 0){
                            ex = tryInt("ID não encontrado, digite outro ID ou 0 para cancelar busca: ");
                            if(ex == 0){break;}
                        }
                    }while(igual == 0);
                    if(ex == 0){break;}
                    do{
                        esc2 = tryInt("Digite a opção para editar: \n"
                            + "1 - ID\n"
                            + "2 - Item\n"
                            + "3 - Marca\n"
                            + "4 - Cor\n"
                            + "5 - Peso\n"
                            + "6 - Fabricante\n"
                            + "7 - Ano de fabricação\n"
                            + "8 - Preço\n"
                            + "9 - Isolado(s/n)\n"
                            + "0 - Sair");
                        switch(esc2){
                            case 1:
                                ferramenta.setID(tryInt("Digite um novo ID: ", ferramenta.getID()));
                                igual=0;
                                while(ferramenta.getID() <= 0){
                                    ferramenta.setID(tryInt("ID inválido, digite um ID maior que 0: "));
                                }
                                igual = verificaIDsem(array, ferramenta, ferramenta1, y);
                                while(igual != 0){
                                    ferramenta.setID(tryInt("ID já utilizado, digite um novo ID: "));
                                    while(ferramenta.getID() <= 0){
                                        ferramenta.setID(tryInt("ID inválido, digite um ID maior que 0: "));
                                    }
                                    igual = verificaIDsem(array, ferramenta, ferramenta1, y);
                                }
                                break;
                            case 2:
                                ferramenta.setItem(JOptionPane.showInputDialog("Digite o Item: ", ferramenta.getItem()));
                                break;
                            case 3:
                                ferramenta.setMarca(JOptionPane.showInputDialog("Digite a Marca: ", ferramenta.getMarca()));
                                break;
                            case 4:
                                ferramenta.setCor(JOptionPane.showInputDialog("Digite a Cor: ", ferramenta.getCor()));
                                break;
                            case 5:
                                ferramenta.setPeso(tryFloat("Digite o Peso: ", ferramenta.getPeso()));
                                break;
                            case 6:
                                ferramenta.setFabricante(JOptionPane.showInputDialog("Digite o Fabricante: ", ferramenta.getFabricante()));
                                break;
                            case 7:
                                ferramenta.setAno_de_Fabricacao(tryInt("Digite o ano de fabricação: ", ferramenta.getAno_de_Fabricacao()));
                                break;
                            case 8:
                                ferramenta.setPreco(tryFloat("Digite o Preço: ", ferramenta.getPreco()));
                                break;
                            case 9:
                                ferramenta.setIsolado(JOptionPane.showInputDialog("Isolado(s/n)? ", ferramenta.getIsolado()).charAt(0));
                                while(ferramenta.getIsolado() != 's' && ferramenta.getIsolado() != 'S' && ferramenta.getIsolado() != 'n' && ferramenta.getIsolado() != 'N'){
                                    ferramenta.setIsolado(JOptionPane.showInputDialog("Inválido, digite novamente (s/n): ").charAt(0));
                                }
                                break;
                            case 0:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    }while(esc2 != 0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }while(esc != 0);
    }
}
