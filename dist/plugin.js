var capacitorLocalStorageMigrator = (function (exports, core) {
    'use strict';

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

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
