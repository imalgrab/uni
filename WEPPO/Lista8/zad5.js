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
        let pool = await sql.connect(config);
        // let insertQuery = await pool.request().query('insert into OSOBA (Imie, Nazwisko, Wiek, Plec, ID_Miejsca_Pracy) values (\'Mikołaj\', \'Głowica\', 6, \'M\', 3)');
        // let insertQuery2 = await pool.request().query('insert into OSOBA_MP (osobaID, miejsceID) values (10, 3)');
        let selectQuery = await pool.request().query('select Imie, Nazwisko, Wiek, Nazwa from OSOBA o, MIEJSCE_PRACY mp where o.ID in (select osobaID from OSOBA_MP) and mp.ID in (select miejsceID from OSOBA_MP);');
        console.log(selectQuery);
    } catch (err) {
        console.log(err);
    }
})()
