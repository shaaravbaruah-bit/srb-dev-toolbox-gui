from PyQt6.QtWidgets import (
    QMainWindow, QTabWidget, QStatusBar, QWidget, 
    QVBoxLayout, QMenuBar, QMenu, QMessageBox
)
from PyQt6.QtGui import QAction, QFont
from PyQt6.QtCore import Qt

from ui.tools import (
    JsonFormatter, Base64Tool, HashGenerator,
    PasswordGenerator, UrlEncoder
)


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("开发者工具箱")
        self.setMinimumSize(1000, 750)
        self.resize(1100, 800)
        
        self._init_menu_bar()
        self._init_ui()
        self._init_status_bar()

    def _init_menu_bar(self):
        menu_bar = self.menuBar()

        file_menu = menu_bar.addMenu("文件(&F)")
        
        exit_action = QAction("退出(&X)", self)
        exit_action.setShortcut("Ctrl+Q")
        exit_action.triggered.connect(self.close)
        file_menu.addAction(exit_action)

        edit_menu = menu_bar.addMenu("编辑(&E)")
        
        clear_all_action = QAction("清除所有(&C)", self)
        clear_all_action.setShortcut("Ctrl+Shift+C")
        clear_all_action.triggered.connect(self._clear_all_tabs)
        edit_menu.addAction(clear_all_action)

        help_menu = menu_bar.addMenu("帮助(&H)")
        
        about_action = QAction("关于(&A)", self)
        about_action.triggered.connect(self._show_about)
        help_menu.addAction(about_action)

    def _init_ui(self):
        central_widget = QWidget()
        self.setCentralWidget(central_widget)
        
        layout = QVBoxLayout(central_widget)
        layout.setContentsMargins(5, 5, 5, 5)

        self.tab_widget = QTabWidget()
        self.tab_widget.setDocumentMode(True)
        self.tab_widget.setMovable(True)
        self.tab_widget.setTabsClosable(False)
        
        self.json_formatter = JsonFormatter()
        self.base64_tool = Base64Tool()
        self.hash_generator = HashGenerator()
        self.password_generator = PasswordGenerator()
        self.url_encoder = UrlEncoder()

        self.tab_widget.addTab(self.json_formatter, "📄 JSON 格式化")
        self.tab_widget.addTab(self.base64_tool, "🔐 Base64 编解码")
        self.tab_widget.addTab(self.hash_generator, "🔑 哈希生成器")
        self.tab_widget.addTab(self.password_generator, "🔒 密码生成器")
        self.tab_widget.addTab(self.url_encoder, "🌐 URL 编解码")

        layout.addWidget(self.tab_widget)

    def _init_status_bar(self):
        self.status_bar = QStatusBar()
        self.setStatusBar(self.status_bar)
        self.status_bar.showMessage("就绪 | 选择一个工具开始使用")

    def _clear_all_tabs(self):
        current_index = self.tab_widget.currentIndex()
        if current_index >= 0:
            current_widget = self.tab_widget.currentWidget()
            if hasattr(current_widget, 'clear_all'):
                current_widget.clear_all()

    def _show_about(self):
        QMessageBox.about(
            self,
            "关于开发者工具箱",
            """<h2>开发者工具箱</h2>
            <p>版本: 1.0.0</p>
            <p>一个功能强大的开发者工具集合</p>
            <h3>包含工具:</h3>
            <ul>
                <li>📄 JSON 格式化与验证</li>
                <li>🔐 Base64 编解码</li>
                <li>🔑 哈希生成器 (MD5, SHA 系列)</li>
                <li>🔒 密码生成器 (安全随机数)</li>
                <li>🌐 URL 编解码</li>
            </ul>
            <h3>技术栈:</h3>
            <p>Python + PyQt6</p>
            <p style='color: gray; font-size: 11px;'>基于 Java 项目 srb-dev-toolbox-gui 重构</p>
            """
        )

    def closeEvent(self, event):
        reply = QMessageBox.question(
            self, '确认退出',
            '确定要退出开发者工具箱吗？',
            QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No
        )
        
        if reply == QMessageBox.StandardButton.Yes:
            event.accept()
        else:
            event.ignore()
