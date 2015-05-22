package org.viz.lightning.types

trait Style {

  def name: String
  def defined: Boolean
  def validate = true: Boolean
  def value: Any

}

case class Label(label: Array[Int]) extends Style {

  def name = "label"
  def defined = label.length > 0
  def value = label.toList

}

case class Colormap(colormap: String) extends Style {

  def name = "colormap"
  def defined = colormap != ""
  override def validate = {
    val valid = List("BrBG", "PiYG", "PRGn", "PuOr", "RdBu", "RdGy", "RdYlBu", "RdYlGn",
      "Spectral", "Blues", "BuGn", "BuPu", "GnBu", "Greens", "Greys", "Oranges", "OrRd",
      "PuBu", "PuBuGn", "PuRd", "Purples", "RdPu", "Reds", "YlGn", "YlGnBu", "YlOrBr",
      "YlOrRd", "Accent", "Dark2", "Paired", "Pastel1", "Pastel2",
      "Set1", "Set2", "Set3")
    if (!valid.contains(colormap)) {
      throw new IllegalArgumentException("Colormap must be one of %s, got %s".format(valid, colormap))
    } else {
      true
    }
  }
  def value = colormap

}

case class Axis(axis: String, name: String) extends Style {

  def defined = axis != ""
  def value = axis

}

case class Alpha(alpha: Array[Double]) extends Style {

  def name = "alpha"
  def defined = alpha.length != 0
  def value = alpha.toList

}

case class Size(size: Array[Double]) extends Style {

  def name = "size"
  def defined = size.length != 0
  def value = size.toList

}

