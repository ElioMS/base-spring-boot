package com.elioms.cambioymoneda.auth;

public class JwtConfig {

    public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\n" +
            "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAumaObK2k/Ojz/z9KqUpq\n" +
            "/JG2uAjWOLvgxv+jGtISF+QpiUcMOSJwfFaoIrVdFpHTWlVRHGWklQrn4uh5+Nm2\n" +
            "lrrjRyjoPyGSb+HSORaqRlV1iY2W1QBPwmzQaPq327qUBzKoxmhC1bdZsV/nDTet\n" +
            "vMKPKzBzIIkiu4eKT+3OWUU1t2Xt2C2KzrfRqLSRA1OgVk6AIQ88o08mjsH9rdar\n" +
            "ir2aCeDBlTslyV1bDVhfs/V6dVjnSWv7FoFH6mtpO8t9BhwmFuKEIA0IWujlgNtk\n" +
            "WzPlPcAirSdRyXmKPwk5wqxeUCDiJkJBZD9uerkliahcGaIL26UYpDF962wfdQSf\n" +
            "YXQDzrLwlidUqtAZMBYx1FBcFP3CB4ZH+4ADPnkUHh3uSThtIcVUytme4S2uXv3S\n" +
            "bjSg6H808nFRIS/vPyyVbRQYCoaApBl190SZbIYnm8dfs0yIOXmnBESUDIZFXP/f\n" +
            "iZGc1UVSvY9jSGAZf/8W6rW6BOqjZhgAsc9X2f7jEsKbLfnMwpzWQzxAeWBQFnHB\n" +
            "pGH+Bpn2yllJcW/SLPzojGys7ml27U7doHVmvByIoYokJONFjuaiBJ459Ok1Hyg9\n" +
            "lSWd/52mBGkSVoyE7F4zBjZusG6hDzWil6FhIOX75AKTb5zcB9raHXSWlEKq7LfQ\n" +
            "ksq2xgk11T6aU+HoWuNPmc8CAwEAAQ==\n" +
            "-----END PUBLIC KEY-----";

    public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIJKQIBAAKCAgEAumaObK2k/Ojz/z9KqUpq/JG2uAjWOLvgxv+jGtISF+QpiUcM\n" +
            "OSJwfFaoIrVdFpHTWlVRHGWklQrn4uh5+Nm2lrrjRyjoPyGSb+HSORaqRlV1iY2W\n" +
            "1QBPwmzQaPq327qUBzKoxmhC1bdZsV/nDTetvMKPKzBzIIkiu4eKT+3OWUU1t2Xt\n" +
            "2C2KzrfRqLSRA1OgVk6AIQ88o08mjsH9rdarir2aCeDBlTslyV1bDVhfs/V6dVjn\n" +
            "SWv7FoFH6mtpO8t9BhwmFuKEIA0IWujlgNtkWzPlPcAirSdRyXmKPwk5wqxeUCDi\n" +
            "JkJBZD9uerkliahcGaIL26UYpDF962wfdQSfYXQDzrLwlidUqtAZMBYx1FBcFP3C\n" +
            "B4ZH+4ADPnkUHh3uSThtIcVUytme4S2uXv3SbjSg6H808nFRIS/vPyyVbRQYCoaA\n" +
            "pBl190SZbIYnm8dfs0yIOXmnBESUDIZFXP/fiZGc1UVSvY9jSGAZf/8W6rW6BOqj\n" +
            "ZhgAsc9X2f7jEsKbLfnMwpzWQzxAeWBQFnHBpGH+Bpn2yllJcW/SLPzojGys7ml2\n" +
            "7U7doHVmvByIoYokJONFjuaiBJ459Ok1Hyg9lSWd/52mBGkSVoyE7F4zBjZusG6h\n" +
            "DzWil6FhIOX75AKTb5zcB9raHXSWlEKq7LfQksq2xgk11T6aU+HoWuNPmc8CAwEA\n" +
            "AQKCAgATUKM7gbbR+jWmYmGTL0Hs0BCV+1xvXpCJLl4xXkk/roXbUsBifz4WtEgR\n" +
            "6KcvuoajGqof/ixSwWGL8rkI3057SfxZGFUQjaMF8ul8vuuABET8ru5NPg4FwI7M\n" +
            "AgbhPvEt2cMBZDZgvPIPXjer9/QJ1kNNn2Sen3c45W+gnqy+NVy+l1JRD08N4qBY\n" +
            "EfXg2V6I8vN1+YU4CvCc5F8sD02RP9phYafNleZxejoAJQMtu6cn18GHqyfGijjw\n" +
            "gpbR+mEHLA2KW4iDZbZS7UUy2AkLJlJ/1pQBS0y/StfXdlZE5OWU+gNVIZJzF9uT\n" +
            "3fGU1RxOD6uY4/+sq/A3X+nWj1cQbY5i1BN0ybRhncm2hf0NScjRn/304jtnMhrr\n" +
            "1k3ElrOvZC/qYXjnDu6eApy9oL9UYVPfocAK57fBcmf0ZWMoKVdG/mErTeK25RdG\n" +
            "zbMR59K+WdWupHnuHqbzVzzn32tVL3CiooyClU3o8D2AmI2JvrzEMyNMWsS9I21N\n" +
            "XvB/IaylYDhCgnAoxIxk/Z/6L+awSCZOnkMYJYSl3odJlw6ByzxjgkYCXiQvhRDq\n" +
            "4Qeo9Y6Meung9beMFA5ChyMZllKuOIVkgdDWEBT+Co/FkzqVANs3trb+brFR7BUo\n" +
            "m+ejTRNOliEVP+cJTZwtAZjFE+pedyIZ8WYt1+wIs2Kkmej8QQKCAQEA9Dlki/fr\n" +
            "lTKtBOR4BdmQ9Hrt1v8Bzh09cLpSGwUn/664KS51QnodmafrpAJ95xbiPyQNlJzy\n" +
            "672ldJzzCnPY4OkW+GYmfzzqu5XZWjlmbEkJNbirJpbNozMjMSYZP22Pj3OsrixJ\n" +
            "SD5LtI4xzKOfG4QKx6K/CKMS4DA3i7q5Aj+oxPLXhwPW1Q5xmkWCYURZD3wW/2DV\n" +
            "83kvQd2kwiM7k+bDEiC6fa7fyhQ/cGfjuB9s/mRum/IZT4jALbBnkHomwnueuFoU\n" +
            "9lL39j4HetbtYQmRMV5iRhqYpxA5RqyXL2mNe1HeUgV4XKgQWIrzlqPy40dr/g86\n" +
            "3cA4Kjlq/+Qx7wKCAQEAw2NpfnSLKcf/JPzXIyvry4ipqlcGd1rnKvzaYKMAWqDl\n" +
            "ixFXOdy65wMZh5uCfR5/FFoZnt9yZLeXPpEu8WfmljJeg6fAxr4DrwsxkzmUWy1Z\n" +
            "9hasD7cJos7y+c+RsmBjFBLW0Zza+K20Zj2UnObJnOffEuzEiVl6SVjWMtoDfowI\n" +
            "z8MCPhhEpNLmj9WVY21qut5DuNRdjJLfjsFMKlTLyUYVrZsCS6OgPYg+s1hrmFxT\n" +
            "HNiJN7TdfNIOREJhg8Yf+FDR8OTzrGJUKWpJUBJkBcB6WvoHKAK2z4bl/7qw4iTh\n" +
            "42116LiNi9Tu+4L6Rbk4SzwxsF8297hFSAy6Qy92IQKCAQBQ3YARaHG04Saw7AVh\n" +
            "ynxYtytxeNZcLQpe/RKap8Zqvqtz11I0RMLwUc2QbNLLZaRcS8/DWYSF0jGqvx0q\n" +
            "ZNl2/zb/4LL2hnEi06c4XLExQa2vAAqLqHtGgnQwnfDWM6zJTv/qW/eX2CixDDQp\n" +
            "EjRoo/v9xkGC1pw1Z0G9HoKL4BA9xjrfFcJYoYO0FTfqhPsISYpD3Qh6qbGgGYeo\n" +
            "UIo1mr8UjYmye+jVvIaU7ZFVMfKg+Rg2wp7m2tznQ/XGvOuAkfYoDIvMVASOoFNR\n" +
            "tUC8VLKiqiHYHI5XIuQUJqmYpVaXcrAucGk+JNfkuX2Wb4rI/qkfYmOXcUInmQN4\n" +
            "31I5AoIBAQCfwh816HEJPqAeTCZUecsY5qtjvjhpSwiNG6YrMdxOPhSx+wHJK/Qe\n" +
            "g2hSexLc3xylNW6Rer58H6ko3Wj2ti/SS2kAWR/E4QT+ETb93CyzyIcwMiWJy+2z\n" +
            "E2eUXuYQZcNdXHINfiWFA/LnTh6/k+zxwJ2jSbkBXQoiAuNRPPVyeWmTBy5EO2+V\n" +
            "HWSr4sV9QK/uD2JsNCgxkr38aYyvaBogfo+nHYFo+2dAKLCrz/ZZ49OJWHwJ8nbP\n" +
            "YqmLooM9TbhCP0MJpwqevt915ZQARqlGErV4wcssKdv0H6bbzHho0CNq48tu98e0\n" +
            "t+yX9eZRMDsZOSSfw5qcPi1X1iBOYvZBAoIBAQCkfSVMm1PoVPBQyzUxA1yi5Y1+\n" +
            "gaEppgT4+9zL2Gp7UcjMikw3Nvoimdh8hCp/+VW1aIMH8L2laoIyBqrOJGLfJpTw\n" +
            "H/6RUUnM+TbAg3p9hmK6PvMmruSUXos2LNjpfSrqQYYPHBodB4zt+z9CKTJhaUB2\n" +
            "cZm+tH/voKlZoCVK78F+KhZ4MXfnT2JjXAo9clT6f2cbUQgGqqqclg7xa79GQSzZ\n" +
            "uSmgG2nmtNPsFu72yhpUDqbRBH44eIadh8FyfJfm9mAO6BHZuIvRri0U7koypOSl\n" +
            "1HDLD5sbz4I5dU8w+AENHSSN6BjozLjRWN8CfAy+4JRJwLdayu7AYKRKQCDn\n" +
            "-----END RSA PRIVATE KEY-----";

}
