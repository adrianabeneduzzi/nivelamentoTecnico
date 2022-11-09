package app;

import dto.Acompanhante;
import dto.Viagem;
import dto.ViagemInternacional;
import dto.ViagemNacional;
import enums.Destinos;

import java.util.ArrayList;
import java.util.List;

public class app {
    public static void main(String[] args){
        Viagem viagem = new Viagem(Destinos.OSASCO);

        viagem.setDestino(Destinos.RECIFE);

        viagem.setDestino(Destinos.MARINGA);

        Acompanhante acompanhante1 = new Acompanhante();
        acompanhante1.setNome("Victória");
        acompanhante1.setConfirmouCadastro(true);

        Acompanhante acompanhante2 = new Acompanhante();
        acompanhante2.setNome("Adriana");
        acompanhante2.setConfirmouCadastro(false);

        List<Acompanhante> acompanhantes = new ArrayList<Acompanhante>();
        acompanhantes.add(acompanhante1);
        acompanhantes.add(acompanhante1);
        acompanhantes.add(acompanhante1);
        acompanhantes.add(acompanhante1);
        acompanhantes.add(acompanhante1);

        try {
            viagem.setAcompanhantes(acompanhantes);
        } catch (Exception excessao){
            System.out.println("Ocorreu um erro: ");
            System.out.println(excessao.getMessage());
        }

        System.out.println(viagem.getDestino().getCidade());
        //System.out.println(viagem.getAcompanhantes().size());
        //System.out.println(viagem.getAcompanhantes().get(0).getNome());
        //System.out.println(viagem.getAcompanhantes().get(1).getNome());

        /* Exemplo 1
        for(int iterador = 0 ; iterador < viagem.getAcompanhantes().size(); iterador ++) {
            System.out.println(viagem.getAcompanhantes().get(iterador).getNome());
            System.out.println(viagem.getAcompanhantes().get(iterador).isConfirmouCadastro());
        }
        */

        for (Acompanhante acompanhante : viagem.getAcompanhantes()) {
            System.out.println(acompanhante.getNome() + "" + acompanhante.isConfirmouCadastro());
        }

        ViagemNacional viagemNacional1 = new ViagemNacional(Destinos.GOIAS);

        try {
            viagemNacional1.setAcompanhantes(acompanhantes);
        }catch (Exception excessao) {
            System.out.println("Ocorreu um problema: ");
            System.out.println(excessao.getMessage());
        }
        viagemNacional1.setCpf("06919733935");

        ViagemInternacional viagemInternacional1 = new ViagemInternacional(Destinos.ACAPULCO);

        try {
            viagemInternacional1.setAcompanhantes(acompanhantes);
        }catch (Exception excessao){
            System.out.println("Ocorreu um problema: ");
            System.out.println(excessao.getMessage());
        }
        viagemInternacional1.setPassaporte("12345-8");

        System.out.println(viagemNacional1.getDestino().getCidade());
        System.out.println(viagemInternacional1.getDestino().getCidade());

        System.out.println(viagemNacional1.getCpf());
        System.out.println(viagemInternacional1.getPassaporte());

        System.out.println(viagemInternacional1.calcularPrevisaoDeDiasParaRetorno());
    }

}