'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const LocalStorageMigrator = core.registerPlugin('LocalStorageMigrator', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.LocalStorageMigratorWeb()),
});

class LocalStorageMigratorWeb extends core.WebPlugin {
    async read({ key }) {
        return { value: localStorage.getItem(key) };
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    LocalStorageMigratorWeb: LocalStorageMigratorWeb
});

exports.LocalStorageMigrator = LocalStorageMigrator;
//# sourceMappingURL=plugin.cjs.js.map
