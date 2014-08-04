function () {
  if (this.saleInfos) {
    for (var i = 0; i < this.saleInfos.length; i++) {
      var saleInfo = this.saleInfos[i];
      emit(this.goodsType, saleInfo.saleMoney);
    }
  }
}