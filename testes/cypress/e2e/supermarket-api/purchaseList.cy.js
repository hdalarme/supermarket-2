/// <reference types = "Cypress"/>

describe('Listas', () => {

    it('Listar Todas as listas', () => {
        cy.request({
            method: 'GET',
            url: 'localhost:8081/api/v1/lists',
        }).then((res) => {
            expect(res.status).to.eq(200)

        })
    })

    it('Listar uma unica lista', () => {
        cy.request({
            method: 'GET',
            url: 'localhost:8081/api/v1/lists/1',
            headers: {Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoZGFsYXJtZUB5YWhvby5jb20uYnIiLCJpYXQiOjE2Nzg4NDQyMDAsImV4cCI6MTY3ODg0NTY0MH0.UxYIZWH14oE7fMFpJP1tC4bYTQKX2dvn1lfPRKsr2QI'}
        }).should(({ status, body}) => {
            const {name, user} = body

            expect(status).to.eq(200)
            expect(name).to.eq('Lista teste 1')
            expect(user).to.eq(1)
        })
    })

})

