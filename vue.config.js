module.exports = {
  //关闭eslint的校验
  lintOnSave: false,
  configureWebpack: {
    devtool: 'source-map'
  },
  devServer: {
    proxy: 'http://localhost:8888'
  }

}
