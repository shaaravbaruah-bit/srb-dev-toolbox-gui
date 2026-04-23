import base64
import binascii
from urllib.parse import quote, unquote


class Base64Handler:
    @staticmethod
    def encode(data: str, encoding: str = 'utf-8', url_safe: bool = False) -> str:
        try:
            bytes_data = data.encode(encoding)
            if url_safe:
                encoded = base64.urlsafe_b64encode(bytes_data)
            else:
                encoded = base64.b64encode(bytes_data)
            return encoded.decode('ascii')
        except UnicodeEncodeError as e:
            raise ValueError(f"编码错误: {e}")

    @staticmethod
    def decode(data: str, encoding: str = 'utf-8', url_safe: bool = False) -> str:
        try:
            if url_safe:
                decoded = base64.urlsafe_b64decode(data)
            else:
                decoded = base64.b64decode(data)
            return decoded.decode(encoding)
        except binascii.Error as e:
            raise ValueError(f"Base64 解码错误: 输入不是有效的 Base64 字符串\n{e}")
        except UnicodeDecodeError as e:
            raise ValueError(f"解码后无法使用 {encoding} 编码解析: {e}")


class UrlHandler:
    @staticmethod
    def encode(data: str, encoding: str = 'utf-8', safe: str = '') -> str:
        try:
            return quote(data, safe=safe, encoding=encoding)
        except Exception as e:
            raise ValueError(f"URL 编码错误: {e}")

    @staticmethod
    def decode(data: str, encoding: str = 'utf-8') -> str:
        try:
            return unquote(data, encoding=encoding)
        except Exception as e:
            raise ValueError(f"URL 解码错误: {e}")
