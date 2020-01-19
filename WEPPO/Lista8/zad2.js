var sql = require('mssql');

var config = {
    server: 'LAPTOP-5CM43C95\\SQLEXPRESS',
    database: 'WEPPO',
    user: 'nodejs',
    password: 'weppo',
    port: 1433
};


(async function () {
    try {
        let pool = await sql.connect(config)
        let insertExample = await pool.request().query('insert into OSOBA (Imie, Nazwisko, Wiek, Plec) values (\'Anna\', \'Komorska\', 36, \'M\')');
        let insertExample2 = await pool.request().query('insert into OSOBA (Imie, Nazwisko, Wiek, Plec) values (\'Monika\', \'Kudlinska\', 14, \'M\')');

        let scope = await pool.request().query('select SCOPE_IDENTITY()');

        let updateExample = await pool.request().query('update OSOBA set Plec = \'K\' where Imie like \'%a\'');

        let deleteExample = await pool.request().query('delete from OSOBA where Imie = \'Anna\'');

        let selectExample = await pool.request().query('select * from OSOBA where Plec = \'K\'');

        pool.request().query('insert into MIEJSCE_PRACY (nazwa) values (\'Google\')');

        pool.request().query('update OSOBA set Id_Miejsca_Pracy = 1 where Wiek = 22');

        console.log(insertExample);
        console.log(insertExample2);
        console.log(updateExample);
        console.log(selectExample);
        console.log(scope);

    } catch (err) {
        console.log(err);
    }
})()