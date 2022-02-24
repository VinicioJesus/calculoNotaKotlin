package br.senai.calculadoradenotas

fun situacaoAluno(media: Int): String {
    if(media >= 5) {
        return "aprovado"
    }else {
        return "reprovado"
    }
}

/*    private fun calcularMedia(nota1: Int, nota2: Int): Int {
        return  (nota1 + nota2) / 2
    }*/
//    private fun calcularMedia(nota1: Int, nota2: Int) = (nota1 + nota2) / 2

//  val calcularMedia = { nota1: Int, nota2: Int -> (nota1 + nota2) / 2 }

/*o vararg faz uma variável conseguir receber diversos valores(virar uma espécie de array)*/
fun calcularMedia (vararg notas:Int): Int{
    var soma = 0;
    /*o parâmetro in faz com que um valor percorra um array*/
    for (nota in notas) {
        soma += nota;
    }
    return soma / notas.size
}