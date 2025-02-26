# BreakfastProject
## 早餐點餐系統
---
##  使用技術

1. Java
2. MySQL
3. MVC
4. dao pattern

## 使用方式


1. 首先下載BreakfastProject.jar+src資料夾+SQL資料夾
2. 確認電腦環境已安裝Java 11與MySQL，開啟MySQL程式，將MySQL匯入SQL資料夾的
3. 執行BreakfastProject.jar檔就可以開始操作了

##程式結構

```
str
├── controller 動態類別(UI介面)
│   ├── comstomer 與客戶相關的資訊
│   │   ├── AddCostomerUI 顧客註冊頁面
│   │   ├── CustomerUI 顧客管理系統
│   │   └── UpdateCustomerUI 客戶個資管理頁面
│   ├── employee 與員工相關的資訊
│   │   └── EmployeeUI 員工管理系統
│   ├── porder 與訂單相關的資訊
│   │   └── PorderUI 訂單管理系統
│   ├── product 與產品相關的資訊
│   │   └── ProductUI 產品管理系統
│   ├── ExcelFormattingExample 測試Excel輸出用
│   ├── LoginDbCUI 連接MySQL的資料庫(user與密碼)
│   ├── LoginUI 登入介面
│   ├── ManageUI 後台管理介面
│   └── MenuUI 菜單介面
├── dao Dao架構，製作JAVA與MySQL連接的方法
│   ├── impl 繼承Dao底下所有抽象類別的Methods的資料夾
│   │   ├── CustomerDaoImpl 實作CustomerDao所儲存的方法
│   │   ├── EmployeeDaoImpl 實作EmployeeDao所儲存的方法
│   │   ├── PorderDaoImpl 實作PorderDao所儲存的方法
│   │   └── ProductDaoImpl 實作ProductDao所儲存的方法
│   ├── CustomerDao 建立Customer類別與顧客資料表連接的方法
│   ├── EmployeeDao 建立Employee類別與員工資料表連接的方法
│   ├── PorderDao 建立Porder類別與訂單資料表連接的方法
│   └── ProductDao 建立Product類別與產品資料表連接的方法
├── model 靜態類別
│   ├── Customer 顧客的靜態類別
│   ├── Employee 員工的靜態類別
│   ├── Porder 訂單的靜態類別
│   └── Product 產品的靜態類別
├── Resource 圖片存放
│   └── a1 菜單背景圖
├── service Service架構，製作連接Dao架構與動態類別連接的方法
│   ├── impl impl 繼承Service底下所有抽象類別的Methods的資料夾
│   │   ├── CustomerServiceImpl 實作顧客資料表與UI連結的方法
│   │   ├── EmployeeServiceImpl 實作員工資料表與UI的連結的方法
│   │   ├── PorderServiceImpl 實作訂單資料表與UI的連結的方法
│   │   └── ProductServiceImpl 實作產品資料表與UI的連結的方法
│   ├── CustomerService 建立顧客資料表與UI連接的方法
│   ├── EmployeeService 建立員工資料表類別與UI連接的方法
│   ├── PorderService 建立訂單資料表與UI連接的方法
│   └── ProductService 建立產品資料表與UI連接的方法
└── util 工具Method資料夾
    ├── DbConnection 連接資料庫的方法
    ├── RegularTool 正規表示法驗證的方法
    └── Tool 其他的方法
```
## 流程圖
![流程圖](%E5%9C%96%E7%89%87%2BPPT/19.png)
