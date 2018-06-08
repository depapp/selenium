import { Selector } from 'testcafe';
import XPathSelector from './xpath-selector';

fixture `amazon testing`
    .page `https://www.amazon.com/`;

    // with nth
    const departments   = Selector('.nav-line-2').nth(6);
    const electro       = Selector('.nav-text').nth(41);
    const tv            = Selector('.nav-text').nth(181);
    // with css
    const inch          = Selector('#a-page > div.a-fixed-left-flipped-grid.s-padding-left-small.s-padding-right-small.s-span-page.a-spacing-top-small > div > div.a-fixed-left-grid-col.a-col-left > div > div:nth-child(1) > div.left_nav.browseBox > ul:nth-child(7) > li:nth-child(1) > a');
    // with xpath
    const inchx         = Selector(XPathSelector('//*[@id="a-page"]/div[4]/div/div[2]/div/div[1]/div[1]/ul[3]/li[1]/a'));
    // with id
    const sort1         = Selector('#sort');

    const sort2         = Selector(XPathSelector('//*[@id="sort"]/option[3]'));
    const maxPrice      = Selector('#high-price');
    const goButton      = Selector(XPathSelector('//*[@id="leftNavContainer"]/ul[3]/div/li/span/form/span[3]/span/input'));
    const tahun         = Selector(XPathSelector('//*[@id="leftNavContainer"]/ul[6]/div/li[2]/span/span/div/label/input'));
    const hasil         = Selector(XPathSelector('//*[@id="result_0"]/div/div[2]/div[2]/div[1]/a/h2'));
    const addToList     = Selector('#add-to-wishlist-button-submit');
    const signInPage    = Selector(XPathSelector('//*[@id="authportal-main-section"]/div[2]/div/div[1]/form/div/div/div/h1'));
    const email         = Selector('#ap_email');
    const kontinyu      = Selector('#continue');
    const error         = Selector(XPathSelector('//*[@id="auth-error-message-box"]/div/div/ul/li/span'));

test('satu', async t => {
    await t
        .maximizeWindow()
        .hover(departments)
        .hover(electro)
        .click(tv)
        .click(inchx)
        .click(sort1)
        .click(sort2)
        .typeText(maxPrice, '150')
        .click(goButton)
        .click(tahun)
        .click(hasil)
        .click(addToList)
        .expect(signInPage.innerText).eql('Sign in')
        .typeText(email, 'helpdesk@mailinator.com')
        .click(kontinyu)
        .expect(error.innerText).eql('We cannot find an account with that email address')
});
