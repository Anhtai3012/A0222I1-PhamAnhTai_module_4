<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 03/10/2022
  Time: 1:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="text-center">
    <h2>TO KHAI Y TE</h2>
    <h4>Day la tai lieu quan trong, thong tin cua anh/chi se giup co quan y te lien lac khi can thiet de
        phong chong dich benh truyen nhiem</h4>
    <h6 class="text-danger mt-3">Khuyen cao: Khai bao thong tin sai la vi pham phap luat Viet Nam va co the xu ly hinh su</h6>
</div>

<form:form method="post" modelAttribute="result" action="/save">
    <form:hidden path="id"></form:hidden>
    <div class="mb-3 row">
        <label for="inputName" class="form-label">Ho va ten (ghi chu in hoa) <span class="text-danger">(*)</span></label>
        <form:input  path="fullName" class="form-control" id="inputName"></form:input>
    </div>

    <div class="mb-3 row">
        <div class="col">
            <label class="form-label">Nam sinh <span style="color: red">(*)</span></label>
            <form:select path="yearBirthday" class="form-select" aria-label="Default select example">
                <option value="1990">1990</option>
                <option value="1991">1991</option>
                <option value="1992">1992</option>
                <option value="1993">1993</option>
                <option value="1994">1994</option>
            </form:select>
        </div>
        <div class="col">
            <label class="form-label">Gioi tinh <span style="color: red">(*)</span></label>
            <form:select path="gender" class="form-select" aria-label="Default select example">
                <option selected>Chon</option>
                <option value="Nam">Nam</option>
                <option value="Nu">Nu</option>
                <option value="3D">3D</option>
            </form:select>
        </div>
        <div class="col">
            <label class="form-label">Quoc tich <span style="color: red">(*)</span></label>
            <form:select path="nationality" class="form-select" aria-label="Default select example">
                <option value="Viet Nam">Viet Nam</option>
                <option value="My">My</option>
                <option value="Trung Quoc">Trung Quoc</option>
            </form:select>
        </div>
    </div>

    <div class="mb-3 row">
        <label class="form-label">So ho chieu hoac so CMND hoac giay thong hanh hop phap khac <span class="text-danger">(*)</span></label>
        <form:input  path="identification" class="form-control"></form:input>
    </div>

    <div class="mb-3 row">
        <label class="form-label">Thong tin di lai <span class="text-danger">(*)</span></label>
        <div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="vehicle" value="Tau bay">
                <label class="form-check-label">Tau bay</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="vehicle" value="Tau thuyen">
                <label class="form-check-label">Tau thuyen</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="vehicle" value="O to">
                <label class="form-check-label">O to</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="vehicle" value="Khac">
                <label class="form-check-label">Khac (ghi ro)</label>
            </div>
        </div>
    </div>

    <div class="mb-3 row">
        <div class="col">
            <label class="form-label">So hieu phuong tien</label>
            <form:input  path="numberPlate" class="form-control"></form:input>
        </div>
        <div class="col">
            <label class="form-label">So ghe</label>
            <form:input  path="numberSeat" class="form-control"></form:input>
        </div>
    </div>

    <div class="mb-3 row">
        <div class="col">
            <label class="form-label">Ngay khoi hanh <span class="text-danger">(*)</span></label>
            <div class="row">
                <div class="col">
                    <select name="startDay" class="form-select" aria-label="Default select example">
                        <option value="1990">01</option>
                        <option value="1991">02</option>
                        <option value="1992">03</option>
                        <option value="1993">04</option>
                        <option value="1994">05</option>
                    </select>
                </div>
                <div class="col">
                    <select name="startMonth" class="form-select" aria-label="Default select example">
                        <option value="1990">01</option>
                        <option value="1991">02</option>
                        <option value="1992">03</option>
                        <option value="1993">04</option>
                        <option value="1994">05</option>
                    </select>
                </div>
                <div class="col">
                    <select name="startYear" class="form-select" aria-label="Default select example">
                        <option value="1990">1990</option>
                        <option value="1991">1991</option>
                        <option value="1992">1992</option>
                        <option value="1993">1993</option>
                        <option value="1994">1994</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="col">
            <label class="form-label">Ngay ket thuc <span class="text-danger">(*)</span></label>
            <div class="row">
                <div class="col">
                    <select name="endDay" class="form-select" aria-label="Default select example">
                        <option value="1990">01</option>
                        <option value="1991">02</option>
                        <option value="1992">03</option>
                        <option value="1993">04</option>
                        <option value="1994">05</option>
                    </select>
                </div>
                <div class="col">
                    <select name="endMonth" class="form-select" aria-label="Default select example">
                        <option value="1990">01</option>
                        <option value="1991">02</option>
                        <option value="1992">03</option>
                        <option value="1993">04</option>
                        <option value="1994">05</option>
                    </select>
                </div>
                <div class="col">
                    <select name="endYear" class="form-select" aria-label="Default select example">
                        <option value="1990">1990</option>
                        <option value="1991">1991</option>
                        <option value="1992">1992</option>
                        <option value="1993">1993</option>
                        <option value="1994">1994</option>
                    </select>
                </div>
            </div>
        </div>
    </div>

    <div class="mb-3 row">
        <label class="form-label">Trong vong 14 ngay qua, Anh/chi co den tinh/thanh pho nao <span class="text-danger">(*)</span></label>
        <textarea class="form-control" name="infoWithin14days" rows="3"></textarea>
    </div>

    <div class="mb-3 row">
        <div class="row">
            <div><h4>Dia chi lien lac</h4> </div>
        </div>
        <div class="row">
            <div class="col">
                <label class="form-label">Tinh/thanh <span style="color: red">(*)</span></label>
                <select name="city" class="form-select" aria-label="Default select example">
                    <option>-Chon-</option>
                    <option value="Da Nang">Da Nang</option>
                    <option value="HCM">HCM</option>
                    <option value="Ha Noi">Ha Noi</option>
                    <option value="Hai Phong">Hai Phong</option>
                </select>
            </div>
            <div class="col">
                <label class="form-label">Quan/huyen <span style="color: red">(*)</span></label>
                <select name="district" class="form-select" aria-label="Default select example">
                    <option selected>Chon</option>
                    <option value="Hai Chau">Hai Chau</option>
                    <option value="Thanh Khe">Thanh Khe</option>
                    <option value="Son Tra">Son Tra</option>
                </select>
            </div>
            <div class="col">
                <label class="form-label">Phuong/xa <span style="color: red">(*)</span></label>
                <select name="ward" class="form-select" aria-label="Default select example">
                    <option value="Xuan Ha">Xuan Ha</option>
                    <option value="Vinh Trung">Vinh Trung</option>
                    <option value="Test">Test</option>
                </select>
            </div>
        </div>
    </div>

    <div class="mb-3 row">
        <label class="form-label">Dia chi noi o <span class="text-danger">(*)</span></label>
        <form:input  path="address" class="form-control"></form:input>
    </div>


    <div class="mb-3 row">
        <div class="col">
            <label class="form-label">Dien thoai <span class="text-danger">(*)</span></label>
            <form:input  path="phone" class="form-control"></form:input>
        </div>
        <div class="col">
            <label class="form-label">Email</label>
            <form:input  path="email" class="form-control"></form:input>
        </div>
    </div>

    <div class="mb-3 row">
        <label class="form-label" style="font-weight: bolder; font-size:larger">Trong vong 14 ngay qua, anh/chi co thay xuat hien dau hieu nao sau day: <span class="text-danger">(*)</span></label>
        <div class="row">
            <div class="col">
                <table class="table">
                    <thead>
                    <td>Trieu chung</td>
                    <td>Co</td>
                    <td>Khong</td>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Sot <span class="text-danger">(*)</span></td>
                        <td> <input class="form-check-input" type="radio" name="sot" value="y"></td>
                        <td> <input class="form-check-input" type="radio" name="sot" value="n"></td>
                    </tr>
                    <tr>
                        <td>Ho <span class="text-danger">(*)</span></td>
                        <td> <input class="form-check-input" type="radio" name="ho" value="y"></td>
                        <td> <input class="form-check-input" type="radio" name="ho" value="n"></td>
                    </tr>
                    <tr>
                        <td>Kho tho <span class="text-danger">(*)</span></td>
                        <td> <input class="form-check-input" type="radio" name="khotho" value="y"></td>
                        <td> <input class="form-check-input" type="radio" name="khotho" value="n"></td>
                    </tr>
                    <tr>
                        <td>Dau hong <span class="text-danger">(*)</span></td>
                        <td> <input class="form-check-input" type="radio" name="dauhong" value="y"></td>
                        <td> <input class="form-check-input" type="radio" name="dauhong" value="n"></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="col">
                <table class="table">
                    <thead>
                    <td>Trieu chung</td>
                    <td>Co</td>
                    <td>Khong</td>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Non/buon non <span class="text-danger">(*)</span></td>
                        <td> <input class="form-check-input" type="radio" name="non" value="y"></td>
                        <td> <input class="form-check-input" type="radio" name="non" value="n"></td>
                    </tr>
                    <tr>
                        <td>Tieu chay <span class="text-danger">(*)</span></td>
                        <td> <input class="form-check-input" type="radio" name="tieuchay" value="y"></td>
                        <td> <input class="form-check-input" type="radio" name="tieuchay" value="n"></td>
                    </tr>
                    <tr>
                        <td>Xuat huyet ngoai da <span class="text-danger">(*)</span></td>
                        <td> <input class="form-check-input" type="radio" name="xuathuyet" value="y"></td>
                        <td> <input class="form-check-input" type="radio" name="xuathuyet" value="n"></td>
                    </tr>
                    <tr>
                        <td>Noi ban ngoai da <span class="text-danger">(*)</span></td>
                        <td> <input class="form-check-input" type="radio" name="noiban" value="y"></td>
                        <td> <input class="form-check-input" type="radio" name="noiban" value="n"></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>

    <div class="mb-3 row">
        <label class="form-label" style="font-weight: bolder; font-size:larger">Lich su phoi nhiem. Trong vong 14 ngay qua, anh/chi co <span class="text-danger">(*)</span></label>
        <table class="table">
            <thead>
            <td></td>
            <td>Co</td>
            <td>Khong</td>
            </thead>
            <tbody>
                <%--            <form:checkboxes path="symptom" id="symptom" cssClass="form-check-input" cssStyle="margin-left: 20px; padding-left: 10px " items="${symptom}"/>--%>
            <tr>
                <td>Den trang trai chan nuoi/ cho buon ban dong vat song/ co so giet mo dong vat/ tiep xuc dong vat <span class="text-danger">(*)</span></td>
                <td> <input class="form-check-input" type="radio" name="dentrangtrai" value="y"></td>
                <td> <input class="form-check-input" type="radio" name="dentrangtrai" value="n"></td>
            </tr>
            <tr>
                <td>Tiep xuc gan (<2m) voi nguoi mac benh vien duong ho hap do nCoV <span class="text-danger">(*)</span></td>
                <td> <input class="form-check-input" type="radio" name="tiepxucgan" value="y"></td>
                <td> <input class="form-check-input" type="radio" name="tiepxucgan" value="n"></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="mb-3 row text-danger">
        Du lieu ban cung cap hoan toan bao mat va chi phuc vu cho viec phong chong dich, thuoc quan ly cua ban chi dao quoc gia va phong chong dich Covid-19.
        Khi ban nhan nut "Gui" la ban da hieu va dong y
    </div>
    <div class="mb-3 row">
        <label class="col-6"></label>
        <div class="col-6">
            <button class="btn btn-success" type="submit">Gui to khai</button>
        </div>
    </div>
</form:form>
</body>
</html>
