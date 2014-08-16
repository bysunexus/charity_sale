function () {
  emit("A", 0);
  emit("B", 0);
  emit("C", 0);
  emit("D", 0);
  emit("E", 0);

  if (this.saleInfos) {
    for (var i = 0; i < this.saleInfos.length; i++) {
      var saleInfo = this.saleInfos[i];
      emit(this.goodsType, saleInfo.saleMoney);
    }
  }
}