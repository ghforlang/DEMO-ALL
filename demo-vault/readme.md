####
1、安装vault服务，安装参照官网执行即可 https://www.vaultproject.io/docs/install
####
2、安装完毕之后，可以在测试环境启动服务，命令如下:
```shell
#本地启动
vault server -dev 
# 启动完成后，查看服务装填
vault status

```
启动完成后，注意查看分配的root token以及unseal，类似
```shell
Unseal Key: RBZ4vKKrmJX+mtW0/96/xKYJjGeuG7S3zTmBi7HHKBA=
Root Token: hvs.It67NLRLLsi1xTXRZlmIQzS2
```
####
3、本地访问vault控制台：http://127.0.0.1:8200,选择方式token登陆，
注意，这里的token可以使用root token，但是，每次服务启动后root token都会变化，可以通过以下命令手动更新
```shell
export VAULT_TOKEN=NEW_TOKEN
```
####
4、处理完成后，可以参照CLI执行相关操作，或者直接在vault控制台进行相关操作
演示kv如下：
(1)创建secret实例，db
```shell
vault kv put -mount=secret db username=fanwh1 password=fanwh1-test
```
(2)查看执行结果
```shell
vault kv get secret/db
#结果如下
= Secret Path =
secret/data/db

======= Metadata =======
Key                Value
---                -----
created_time       2022-08-08T09:38:32.017107Z
custom_metadata    <nil>
deletion_time      n/a
destroyed          false
version            1

====== Data ======
Key         Value
---         -----
password    fanwh-test
username    fanwh
```
(3)查看当前可用的secret path
```shell
vault secrets list 
```

(4)token模式访问,访问之前添加的secret/db,创建临时token，时效1分钟
```shell
vault token create -ttl 1m
#结果如下：
Key                  Value
---                  -----
token                hvs.DyYrDNQ1X3yuHFvg7IBPJ1UI
token_accessor       LGRd9f95ZHtmvJyhi1g0wBgZ
token_duration       2m
token_renewable      true
token_policies       ["root"]
identity_policies    []
policies             ["root"]
```
(5)复制新生成的token，执行export
```shell
export VAULT_TOKEN=hvs.DyYrDNQ1X3yuHFvg7IBPJ1UI
```
(6)尝试使用新token访问secret/db
```shell
vault kv get secret/db
```
(6)过1分钟之后再访问，此时会提示无访问权限
```shell
Error making API request.

URL: GET http://127.0.0.1:8200/v1/sys/internal/ui/mounts/secret/db
Code: 403. Errors:

* permission denied
```

spring版本原因，Main类会报错，暂且不做处理。


