文件上传开源解决方案，参考文档：https://min.io/download#/macos

###
mac server端安装 

`wget https://dl.min.io/server/minio/release/darwin-amd64/minio ## 国外资源，龟速下载，可以直接官网下载，比较快
chmod +x minio
MINIO_ROOT_USER=admin MINIO_ROOT_PASSWORD=password ./minio server F:\Data --console-address ":9001" ## F:\Data 存储目录；--console-address 是 UI 界面的端口,
文件所在路径改为自己的真实路径，用户名密码可自定义`
minio服务启动后，可访问127.0.0.0:9001访问控制台，进行操作；也可直接通过接口访问


### 新增swagger的引入和使用
