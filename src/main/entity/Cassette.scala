package entity

case class Cassette(donnee:Array[Int]=Array.fill[Int](800)(0), table:Array[Int]=Array.fill[Int](200)(0)) {

  def getElement(cassette : Cassette, index:Int): Int = {
    if (index<800) {
      cassette.donnee(index)
    }
    else if (index<1000) {
      cassette.table(index-800)
    }
    else {
      throw new IndexOutOfBoundsException("La Cassette ne peut avoir que 1000 valeurs")
    }
  }
}
